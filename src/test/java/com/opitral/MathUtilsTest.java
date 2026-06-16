package com.opitral;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Simple (non-parameterized) tests plus a demonstration of {@code Assumptions}.
 */
@Tag("unit")
@DisplayName("MathUtils — simple tests")
class MathUtilsTest {

    @Test
    @DisplayName("factorial(5) == 120")
    void factorialOfFive() {
        assertEquals(120L, MathUtils.factorial(5));
    }

    @Test
    @DisplayName("factorial of a negative number is rejected")
    void factorialRejectsNegative() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.factorial(-1));
    }

    @Test
    @DisplayName("factorial stays positive only while it fits into a long")
    void factorialFitsIntoLong() {
        final int n = 21;
        // Logical assumption: a long can hold n! only up to n == 20. For larger n
        // the result overflows, so it is pointless to assert positivity — skip instead.
        assumeTrue(n <= 20, "factorial(n) overflows a long for n > 20");
        assertTrue(MathUtils.factorial(n) > 0);
    }

    @Test
    @DisplayName("gcd is commutative when both arguments are positive")
    void gcdIsCommutative() {
        final int a = 48;
        final int b = 36;
        // Logical assumption: the commutativity check below is only meaningful for
        // strictly positive inputs; run the extra assertion only in that case.
        assumingThat(a > 0 && b > 0,
                () -> assertEquals(MathUtils.gcd(a, b), MathUtils.gcd(b, a)));
        assertEquals(12, MathUtils.gcd(a, b));
    }
}
