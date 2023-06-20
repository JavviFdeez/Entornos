package src.test.java;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static src.main.java.Calculadora miCalculadora;

    @BeforeClass
    public static void setUpClass() {
        miCalculadora = new main.java.Calculadora();
    }

    @Test
    public void testSuma() {
        Assert.assertEquals(5, miCalculadora.suma(2, 3));
        Assert.assertEquals(0, miCalculadora.suma(-5, 5));
        Assert.assertEquals(10, miCalculadora.suma(7, 3));
    }

    @Test
    public void testResta() {
        Assert.assertEquals(2, miCalculadora.resta(5, 3));
        Assert.assertEquals(-7, miCalculadora.resta(2, 9));
        Assert.assertEquals(0, miCalculadora.resta(10, 10));
    }

    @Test
    public void testMultiplica() {
        Assert.assertEquals(6, miCalculadora.multiplica(2, 3));
        Assert.assertEquals(0, miCalculadora.multiplica(5, 0));
        Assert.assertEquals(16, miCalculadora.multiplica(4, 4));
        Assert.assertEquals(-5, miCalculadora.multiplica(-5, 1));
    }

    @Test
    public void testDivisionesEnterasYReales() throws Exception {
        Assert.assertEquals(2, miCalculadora.divide(4, 2));
        Assert.assertEquals(2.5, miCalculadora.divide(10, 4), 0.001);
        Assert.assertEquals(4, miCalculadora.divide(10, 2.5), 0.001);
        Assert.assertEquals(3.2, miCalculadora.divide(8, 2.5), 0.001);
        Assert.assertEquals(0.5, miCalculadora.divide(2, 4), 0.001);
    }

    @Test
    public void testDivisionesPositivosYNegativos() throws Exception {
        Assert.assertTrue(miCalculadora.divide(4, 2) > 0);
        Assert.assertTrue(miCalculadora.divide(4, -2) < 0);
        Assert.assertTrue(miCalculadora.divide(-4, 2) < 0);
        Assert.assertTrue(miCalculadora.divide(-4, -2) > 0);
    }

    @Test(expected = Exception.class)
    public void testDivisionPorCero() throws Exception {
        miCalculadora.divide(5, 0);
    }

    @Test
    public void testPotencia() {
        Assert.assertEquals(8, miCalculadora.potencia(2, 3));
        Assert.assertEquals(1, miCalculadora.potencia(10, 0));
        Assert.assertEquals(16, miCalculadora.potencia(-2, 4));
    }

    @Test
    public void testRaizCuadrada() throws Exception {
        Assert.assertEquals(4, miCalculadora.raizCuadrada(16), 0.001);
        Assert.assertEquals(3, miCalculadora.raizCuadrada(9), 0.001);
        Assert.assertEquals(1, miCalculadora.raizCuadrada(1), 0.001);
        Assert.assertEquals(0, miCalculadora.raizCuadrada(0), 0.001);
    }

    @Test(expected = Exception.class)
    public void testRaizCuadradaDeNumeroNegativo() throws Exception {
        miCalculadora.raizCuadrada(-9);
    }
}
