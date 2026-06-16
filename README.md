# ci-cd

Демонстраційний Java/Gradle проєкт із власним CI/CD pipeline на **GitHub Actions**.

## Pipeline

Конфігурація: [`.github/workflows/ci-cd.yml`](.github/workflows/ci-cd.yml)

> **Посилання на pipeline:** після пушу в GitHub запуски будуть доступні за адресою
> `https://github.com/<OWNER>/<REPO>/actions` (вкладка **Actions**).
> _(Remote ще не налаштований — див. розділ «Як запустити» нижче.)_

Pipeline складається з 4 послідовних кроків (jobs), кожен залежить від попереднього:

| # | Job | Що робить |
|---|-----|-----------|
| 1 | **static-analysis** | Статичний аналіз коду на відповідність стилю — **Checkstyle** (`checkstyleMain`, `checkstyleTest`). Звіти зберігаються як artifact. |
| 2 | **test** | Автоматизоване тестування: окремо запускає **unit**-набір і **integration**-набір. Звіти зберігаються як artifact. |
| 3 | **build** | Збирання проєкту в **runnable JAR** (`./gradlew jar`), JAR завантажується як build artifact. |
| 4 | **publish** | Розгортання/публікація: пуш JAR у **GitHub Packages** (Maven registry). Виконується лише при push у `main`. |

## Технології

- Java 21 (Gradle toolchain), Gradle 9.3
- JUnit **6** (junit-bom 6.0.0)
- Checkstyle 10.21 — статичний аналіз стилю коду
- `maven-publish` → GitHub Packages

## Структура тестів (JUnit 6)

Усі вимоги до тестів реалізовано:

| Тип | Файл | Деталі |
|-----|------|--------|
| Простий тест | `MathUtilsTest` | `factorial(5) == 120`, перевірка винятку тощо |
| Параметризований (1 параметр, статичний) | `MathUtilsParameterizedTest` | `@ParameterizedTest` + `@ValueSource(ints = {...})` |
| Параметризований (набір параметрів, статичний) | `MathUtilsParameterizedTest` | `@ParameterizedTest` + `@CsvSource({...})` |
| Динамічний тест | `MathUtilsDynamicTest` | `@TestFactory` → `Stream<DynamicTest>` |

### Assumptions

`Assumptions` використано з логічним сенсом:

- `MathUtilsTest#factorialFitsIntoLong` — `assumeTrue(n <= 20, ...)`: `long` вміщує `n!`
  лише до `20!`, тож для більших `n` тест свідомо пропускається замість падіння.
- `MathUtilsTest#gcdIsCommutative` — `assumingThat(a > 0 && b > 0, ...)`: додаткова
  перевірка комутативності має сенс лише для додатних аргументів.
- `AppIntegrationTest#smokeCheckOnCi` — `assumeTrue("true".equals(System.getenv("CI")))`:
  важчий end-to-end сценарій виконується лише в середовищі CI.

### Розділення на Suite / набори за тегами

Тести поділено за тегами `@Tag("unit")` та `@Tag("integration")`:

- JUnit Platform **Suite** класи: `suite/UnitTestSuite`, `suite/IntegrationTestSuite`
  (`@Suite` + `@IncludeTags(...)`) — для запуску з IDE.
- Окремі Gradle-задачі, що показують **різницю запусків різних наборів**:

```bash
./gradlew test             # лише unit-набір  -> 28 тестів (1 пропущено через assumption)
./gradlew integrationTest  # лише integration -> 2 тести (1 пропущено локально, виконується в CI)
./gradlew check            # статичний аналіз + обидва набори
```

## Як запустити локально

```bash
./gradlew clean check     # Checkstyle + обидва набори тестів
./gradlew jar             # зібрати JAR
java -jar build/libs/ci-cd-1.0.0.jar
```

## Як активувати pipeline на GitHub

Remote ще не налаштовано. Щоб pipeline запрацював і з'явилось посилання:

```bash
# 1. Створити репозиторій на GitHub, потім:
git add .
git commit -m "Add CI/CD pipeline"
git branch -M main
git remote add origin https://github.com/<OWNER>/<REPO>.git
git push -u origin main
```

Після пушу:
- pipeline запуститься автоматично — дивитись у вкладці **Actions**;
- опублікований JAR з'явиться у **Packages** репозиторію.

> `publish` використовує вбудований `GITHUB_TOKEN` — додаткові секрети не потрібні.
