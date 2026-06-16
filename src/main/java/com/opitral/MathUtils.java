package com.opitral;

/**
 * Small collection of pure mathematical helpers used to demonstrate
 * a full CI/CD pipeline (static analysis, testing, packaging, publishing).
 */
public final class MathUtils {

    private MathUtils() {
        // Utility class: no instances.
    }

    /**
     * Computes {@code n!}.
     *
     * @param n a non-negative number; {@code n <= 20} to fit into a long
     * @return the factorial of {@code n}
     * @throws IllegalArgumentException if {@code n} is negative
     */
    public static long factorial(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative, got " + n);
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Checks whether {@code n} is a prime number.
     *
     * @param n the number to test
     * @return {@code true} if {@code n} is prime
     */
    public static boolean isPrime(final int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Computes the greatest common divisor of {@code a} and {@code b}.
     *
     * @param a first number
     * @param b second number
     * @return the greatest common divisor (always non-negative)
     */
    public static int gcd(final int a, final int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        while (y != 0) {
            final int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    /**
     * Computes the {@code n}-th Fibonacci number (0-indexed).
     *
     * @param n a non-negative index
     * @return the n-th Fibonacci number
     * @throws IllegalArgumentException if {@code n} is negative
     */
    public static long fibonacci(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative, got " + n);
        }
        long previous = 0;
        long current = 1;
        for (int i = 0; i < n; i++) {
            final long next = previous + current;
            previous = current;
            current = next;
        }
        return previous;
    }
}
