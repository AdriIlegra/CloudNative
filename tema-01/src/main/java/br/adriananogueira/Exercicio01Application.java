package br.adriananogueira;

import br.adriananogueira.operation.Calculator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio01Application {

	public static void main(String[] args) {

		Calculator calculator = new Calculator();

		double a = 10;
		double b = 2;

		double result = calculator.sum(a, b);
		System.out.println("sum = " + result);

		result = calculator.sub(a, b);
		System.out.println("sub = " + result);

		result = calculator.multiply(a, b);
		System.out.println("multiply = " + result);

		result = calculator.division(a, b);
		System.out.println("division = " + result);

		result = calculator.pow(a, b);
		System.out.println("pow = " + result);
	}

}
