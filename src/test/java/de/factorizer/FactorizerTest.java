package de.factorizer;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class FactorizerTest {

    private final Factorizer f = Factorizer.getInstance();

    @Test
    @Order(100)
    void test100_factorize_regular_cases() {
        assertEquals(List.of(1), f.factorize(1));
        assertEquals(List.of(2), f.factorize(2));
        assertEquals(List.of(3), f.factorize(3));
        assertEquals(List.of(2, 2), f.factorize(4));
        assertEquals(List.of(3, 3, 3), f.factorize(27));

        List<Integer> twos = new ArrayList<>();
        for (int i = 0; i < 16; i++) twos.add(2);
        assertEquals(twos, f.factorize(65536));

        assertEquals(List.of(7, 23, 59, 1153), f.factorize(10952347));
        assertEquals(List.of(100000039), f.factorize(100000039));
    }

    @Test
    @Order(200)
    void test200_factorize_corner_cases() {
        assertEquals(List.of(0), f.factorize(0));
        assertFactorsMultiplyBack(2_147_483_646);
        assertFactorsMultiplyBack(2_147_483_647);
    }

    private void assertFactorsMultiplyBack(int n) {
        List<Integer> fs = f.factorize(n);
        assertFalse(fs.isEmpty(), "factors should not be empty");
        long prod = 1;
        for (int x : fs) {
            assertTrue(x > 1 || n <= 1, "each factor should be > 1 for n>1");
            prod *= x;
        }
        if (n > 1) assertEquals(n, prod, "product of factors should equal n");
    }

    @Test
    @Order(300)
    void test300_factorize_exception_cases() {
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> f.factorize(-1));
        assertEquals("illegal negative parameter: n", ex1.getMessage());

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> f.factorize(-10));
        assertEquals("illegal negative parameter: n", ex2.getMessage());

        IllegalArgumentException ex3 = assertThrows(IllegalArgumentException.class, () -> f.factorize(Integer.MIN_VALUE));
        assertEquals("illegal negative parameter: n", ex3.getMessage());
    }
}
