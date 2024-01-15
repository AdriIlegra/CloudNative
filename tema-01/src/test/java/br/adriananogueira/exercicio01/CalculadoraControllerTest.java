package br.adriananogueira.exercicio01;

import br.adriananogueira.operation.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;


public class CalculadoraControllerTest {
    @Autowired
    Calculator calculator;

  @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        double a = 10;
        double b = 2;
        double sum = calculator.sum(a, b);
        assertEquals(12, sum, 0);
    }

    @Test
    public void testSub() {
        double a = 10;
        double b = 2;
        double sub = calculator.sub(a, b);
        assertEquals(8, sub, 0);
    }

    @Test
    public void testMultiply() {
        double a = 10;
        double b = 2;
        double multiply = calculator.multiply(a, b);
        assertEquals(20, multiply, 0);
    }

    @Test
    public void testDivision() {
        double a = 10;
        double b = 2;
        double division = calculator.division(a, b);
        assertEquals(5, division, 0);
    }

    @Test
    public void testPow() {
        double a = 10;
        double b = 2;
        double pow = calculator.pow(a, b);
        assertEquals(100, pow, 0);
    }

}


