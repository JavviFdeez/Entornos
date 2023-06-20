package com.example.main;

public class Calculadora {

    public double suma(double a, double b) {
        return a + b;
    }

    public double resta(double minuendo, double sustraendo) {
        return minuendo - sustraendo;
    }

    public double multiplica(double a, double b) {
        return a * b;
    }

    public double divide(double dividendo, double divisor) throws Exception {
        if (divisor == 0) {
            throw new Exception("El divisor es 0");
        }
        return dividendo / divisor;
    }

    public double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    public double raizCuadrada(double radicando) throws Exception {
        if (radicando < 0) {
            throw new Exception("El radicando no puede ser negativo");
        }
        return Math.sqrt(radicando);
    }
}
