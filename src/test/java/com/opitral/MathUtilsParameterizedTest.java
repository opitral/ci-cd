package com.opitral;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("unit")
@DisplayName("MathUtils — parameterized tests")
class MathUtilsParameterizedTest {

    @ParameterizedTest(name = "{0} is prime")
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19})
    @DisplayName("known primes are reported as prime")
    void knownPrimes(final int candidate) {
        assertTrue(MathUtils.isPrime(candidate));
    }

    @ParameterizedTest(name = "gcd({0}, {1}) == {2}")
    @CsvSource({
        "48, 36, 12",
        "17, 5, 1",
        "100, 10, 10",
        "0, 7, 7",
        "-12, 8, 4",
    })
    @DisplayName("gcd returns the expected value")
    void gcdValues(final int a, final int b, final int expected) {
        assertEquals(expected, MathUtils.gcd(a, b));
    }
}
