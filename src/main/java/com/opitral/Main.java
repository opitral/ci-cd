package com.opitral;

public final class Main {

    private Main() {
    }

    public static void main(final String[] args) {
        System.out.println("ci-cd demo application");
        System.out.println("5! = " + MathUtils.factorial(5));
        System.out.println("gcd(48, 36) = " + MathUtils.gcd(48, 36));
        System.out.println("fibonacci(10) = " + MathUtils.fibonacci(10));
        System.out.println("is 13 prime? " + MathUtils.isPrime(13));
    }
}
