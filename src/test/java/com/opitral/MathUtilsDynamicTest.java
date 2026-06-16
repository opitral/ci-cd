package com.opitral;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestFactory;

/**
 * Dynamic tests generated at runtime via {@code @TestFactory}.
 */
@Tag("unit")
@DisplayName("MathUtils — dynamic tests")
class MathUtilsDynamicTest {

    @TestFactory
    @DisplayName("fibonacci sequence matches the known prefix")
    Stream<DynamicTest> fibonacciSequence() {
        final List<Long> expected = List.of(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L);
        return Stream.iterate(0, i -> i + 1)
                .limit(expected.size())
                .map(i -> dynamicTest(
                        "fibonacci(" + i + ") == " + expected.get(i),
                        () -> assertEquals(expected.get(i), MathUtils.fibonacci(i))));
    }
}
