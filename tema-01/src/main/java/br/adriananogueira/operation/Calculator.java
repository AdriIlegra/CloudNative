package br.adriananogueira.operation;

import br.adriananogueira.validation.Validation;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private Validation validation;

    private List<String> history = new ArrayList<>();
    public Calculator() {
        this.validation = new Validation();
    }
    public double sum(double a, double b) {
        validation.ValidationInput(a, b);
        double result = a + b;
        addToHistory(a + " + " + b + " = " + result);
        return result;
    }

    public double sub(double a, double b) {
        validation.ValidationInput(a, b);
        double result = a - b;
        addToHistory(a + " - " + b + " = " + result);
        return result;
    }
    public double multiply(double a, double b) {
        validation.ValidationInput(a, b);
        double result = a * b;
        addToHistory(a + " * " + b + " = " + result);
        return result;
    }
    public double division(double a, double b) {
        validation.ValidationInput(a, b);
        double result = a / b;
        addToHistory(a + " / " + b + " = " + result);
        return result;
    }
    public double pow(double a, double b) {
        validation.ValidationInput(a, b);
        double result = Math.pow(a, b);
        addToHistory(a + " ^ " + b + " = " + result);
        return result;
    }

    public void addToHistory(String operation) {
        history.add(operation);
    }
}
