package com.kucw.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void add() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);

        assertNotNull(result);
        assertEquals(3, result, "加法有錯誤");
    }

    @Test
    public void divide() {
        Calculator calculator = new Calculator();
        // 斷言執行method時，會噴出 exception
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);
        });
    }
}