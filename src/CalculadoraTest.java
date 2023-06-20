import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass() {
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Suma dos números")
    void testSuma() {
        assertEquals(5, miCalculadora.suma(2, 3));
        assertEquals(0, miCalculadora.suma(-5, 5));
        assertEquals(10, miCalculadora.suma(7, 3));
    }

    @Test
    @DisplayName("Resta dos números")
    void testResta() {
        assertEquals(2, miCalculadora.resta(5, 3));
        assertEquals(-7, miCalculadora.resta(2, 9));
        assertEquals(0, miCalculadora.resta(10, 10));
    }

    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplica() {
        assertEquals(6, miCalculadora.multiplica(2, 3));
        assertEquals(0, miCalculadora.multiplica(5, 0));
        assertEquals(16, miCalculadora.multiplica(4, 4));
        assertEquals(-5, miCalculadora.multiplica(-5, 1));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception {
        assertEquals(2, miCalculadora.divide(4, 2));
        assertEquals(2.5, miCalculadora.divide(10, 4));
        assertEquals(4, miCalculadora.divide(10, 2.5));
        assertEquals(3.2, miCalculadora.divide(8, 2.5));
        assertEquals(0.5, miCalculadora.divide(2, 4));
    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.divide(4, 2) > 0);
        assertTrue(miCalculadora.divide(4, -2) < 0);
        assertTrue(miCalculadora.divide(-4, 2) < 0);
        assertTrue(miCalculadora.divide(-4, -2) > 0);
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.divide(5, 0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }

    @Test
    @DisplayName("Calcula la potencia de un número")
    void testPotencia() {
        assertEquals(8, miCalculadora.potencia(2, 3));
        assertEquals(1, miCalculadora.potencia(10, 0));
        assertEquals(16, miCalculadora.potencia(-2, 4));
    }

    @Test
    @DisplayName("Calcula la raiz cuadrada de un número")
    void testRaizCuadrada() throws Exception {
        assertEquals(4, miCalculadora.raizCuadrada(16));
        assertEquals(3, miCalculadora.raizCuadrada(9));
        assertEquals(1, miCalculadora.raizCuadrada(1));
        assertEquals(0, miCalculadora.raizCuadrada(0));
    }

    @Test
    @DisplayName("Intento de calcular raiz cuadrada de un número negativo causa excepción")
    void testRaizCuadradaDeNumeroNegativo() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.raizCuadrada(-9);
        });

        assertEquals("El radicando no puede ser negativo", thrown.getMessage());
    }
}