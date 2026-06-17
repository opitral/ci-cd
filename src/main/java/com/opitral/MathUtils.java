package com.opitral;

public final class MathUtils {

    private MathUtils() {
    }

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
