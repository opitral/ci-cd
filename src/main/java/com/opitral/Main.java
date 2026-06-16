package com.opitral;

/**
 * Application entry point. Prints a short demo of {@link MathUtils}
 * so that the produced JAR is runnable end-to-end.
 */
public final class Main {

    private Main() {
        // Entry-point holder: no instances.
    }

    /**
     * Runs the demo.
     *
     * @param args command-line arguments (ignored)
     */
    public static void main(final String[] args) {
        System.out.println("ci-cd demo application");
        System.out.println("5! = " + MathUtils.factorial(5));
        System.out.println("gcd(48, 36) = " + MathUtils.gcd(48, 36));
        System.out.println("fibonacci(10) = " + MathUtils.fibonacci(10));
        System.out.println("is 13 prime? " + MathUtils.isPrime(13));
    }
}
