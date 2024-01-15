package br.adriananogueira.validation;

public class Validation {

    public void ValidationInput(double a, double b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Não é permitido números negativos");
        }
    }
}
