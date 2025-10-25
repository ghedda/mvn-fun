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
     * Method accepts numbers as args and outputs lines with the number n,
     * its factors and an indicator whether n is a prime number.
     *
     * <p>For example:</p>
     * <ul>
     *   <li>n=3 -> [3] (prime number)</li>
     *   <li>n=27 -> [3, 3, 3]</li>
     *   <li>n=1092 -> [2, 2, 3, 7, 13]</li>
     *   <li>n=65536 -> [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]</li>
     *   <li>n=10952347 -> [7, 23, 59, 1153]</li>
     *   <li>n=100000039 -> [100000039] (prime number)</li>
     * </ul>
     *
     * @param args numbers to factorize
     */

    List<Integer> factorize(Integer n);

    /**
     * Return reference to singleton instance of the hidden implementation.
     */
    static Factorizer getInstance() {
        return FactorizerImpl.getInstance();
    }
}
