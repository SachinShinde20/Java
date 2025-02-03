package com.project.math;

public class CalculationsModule {
    public double add(double n1, double n2) {
        return n1 + n2;
    }

    public double sub(double n1, double n2) {
        return n1 - n2;
    }

    public double mul(double n1, double n2) {
        return n1 * n2;
    }

    public double div(double n1, double n2) {
        if (n2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return n1 / n2;
    }

    public double mod(double n1, double n2) {
        return n1 % n2;
    }
}
