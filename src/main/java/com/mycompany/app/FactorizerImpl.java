package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

class FactorizerImpl implements Factorizer {

    // Lazy, thread-safe singleton (only one instance)
    private static volatile FactorizerImpl INSTANCE;

    private FactorizerImpl() { }

    static FactorizerImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (FactorizerImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FactorizerImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void run(String[] args) {
        System.out.println("Hello Factors!");
        if (args == null || args.length == 0) {
            System.out.println("  (pass one or more integers as arguments)");
            return;
        }

        for (String a : args) {
            try {
                int n = Integer.parseInt(a);
                List<Integer> factors = factorize(n);
                System.out.print(" - n=" + n + " -> " + factors);
                if (isPrime(n)) System.out.print(" (prime number)");
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println(" - n=" + a + " -> [invalid integer]");
            }
        }
    }

    @Override
    public List<Integer> factorize(Integer n) {
        List<Integer> factors = new ArrayList<>();
        if (n == null) return factors;
        int x = n;

        if (x < 0) { // handle negatives
            factors.add(-1);
            x = -x;
        }
        if (x == 0 || x == 1) { // handle edge cases
            factors.add(n);
            return factors;
        }

        // Factor out 2s
        while (x % 2 == 0) {
            factors.add(2);
            x /= 2;
        }

        // Factor odd numbers
        for (int f = 3; f <= Math.sqrt(x); f += 2) {
            while (x % f == 0) {
                factors.add(f);
                x /= f;
            }
        }

        if (x > 1) factors.add(x); // remaining prime

        return factors;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (int f = 3; f * f <= n; f += 2) {
            if (n % f == 0) return false;
        }
        return true;
    }
}
