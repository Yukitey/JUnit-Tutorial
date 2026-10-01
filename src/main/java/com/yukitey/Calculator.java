package com.yukitey;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Делить на ноль нельзя");
        }
        return a / b;
    }
}