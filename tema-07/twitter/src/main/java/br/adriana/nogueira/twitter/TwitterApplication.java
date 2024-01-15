package br.adriana.nogueira.twitter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import java.util.List;
@SpringBootApplication
@ComponentScan(basePackages = "br.adriana.nogueira.twitter")
public class TwitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterApplication.class, args);
	}
}