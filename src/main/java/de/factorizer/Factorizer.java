package de.factorizer;

import java.util.List;

/**
 * Interface of a singleton component that factorizes numbers
 * into prime factors.
 */
public interface Factorizer {

    /**
     * Accept numbers as {@code args} and output lines with the number {@code n},
     * its factors and an indicator whether {@code n} is a prime number.
     */
    void run(String[] args);

    /**
     * Factorize a number {@code n} into prime factors.
     * @param n number to factorize
     * @return factors
     */
    List<Integer> factorize(Integer n);

    /**
     * Return reference to singleton instance of the hidden implementation.
     */
    static Factorizer getInstance() {
        return FactorizerImpl.getInstance();
    }
}
