package com.mycompany.app;

/**
 * Main application that uses the Factorizer singleton
 * to factorize numbers passed as command-line arguments.
 */
public class App {
    public static void main(String[] args) {
        Factorizer factorizer = Factorizer.getInstance();
        factorizer.run(args);
    }
}
