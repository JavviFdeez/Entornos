package com.test;

import com.main.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass() {
        miCalculadora = new Calculadora();
    }

    @Test
    public void testSuma() {
        Assertions.assertEquals(5, miCalculadora.suma(2, 3));
        Assertions.assertEquals(0, miCalculadora.suma(-5, 5));
        Assertions.assertEquals(10, miCalculadora.suma(7, 3));
    }

    @Test
    public void testResta() {
        Assertions.assertEquals(2, miCalculadora.resta(5, 3));
        Assertions.assertEquals(-7, miCalculadora.resta(2, 9));
        Assertions.assertEquals(0, miCalculadora.resta(10, 10));
    }

    @Test
    public void testMultiplica() {
        Assertions.assertEquals(6, miCalculadora.multiplica(2, 3));
        Assertions.assertEquals(0, miCalculadora.multiplica(5, 0));
        Assertions.assertEquals(16, miCalculadora.multiplica(4, 4));
        Assertions.assertEquals(-5, miCalculadora.multiplica(-5, 1));
    }

    @Test
    public void testDivisionesEnterasYReales() throws Exception {
        Assertions.assertEquals(2, miCalculadora.divide(4, 2));
        Assertions.assertEquals(2.5, miCalculadora.divide(10, 4), 0.001);
        Assertions.assertEquals(4, miCalculadora.divide(10, 2.5), 0.001);
        Assertions.assertEquals(3.2, miCalculadora.divide(8, 2.5), 0.001);
        Assertions.assertEquals(0.5, miCalculadora.divide(2, 4), 0.001);
    }

    @Test
    public void testDivisionesPositivosYNegativos() throws Exception {
        Assertions.assertTrue(miCalculadora.divide(4, 2) > 0);
        Assertions.assertTrue(miCalculadora.divide(4, -2) < 0);
        Assertions.assertTrue(miCalculadora.divide(-4, 2) < 0);
        Assertions.assertTrue(miCalculadora.divide(-4, -2) > 0);
    }

    @Test
    public void testDivisionPorCero() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            miCalculadora.divide(5, 0);
        });

        String expectedMessage = "El divisor es 0";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testPotencia() {
        Assertions.assertEquals(8, miCalculadora.potencia(2, 3));
        Assertions.assertEquals(1, miCalculadora.potencia(10, 0));
        Assertions.assertEquals(16, miCalculadora.potencia(-2, 4));
    }

    @Test
    public void testRaizCuadrada() throws Exception {
        Assertions.assertEquals(4, miCalculadora.raizCuadrada(16), 0.001);
        Assertions.assertEquals(3, miCalculadora.raizCuadrada(9), 0.001);
        Assertions.assertEquals(1, miCalculadora.raizCuadrada(1), 0.001);
        Assertions.assertEquals(0, miCalculadora.raizCuadrada(0), 0.001);
    }

    @Test
    public void testRaizCuadradaDeNumeroNegativo() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            miCalculadora.raizCuadrada(-9);
        });

        String expectedMessage = "El radicando no puede ser negativo";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}
