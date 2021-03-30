package Springclase3.CalculadoraCalorias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"Controllers"})
@ComponentScan(basePackages = {"Services"})
@ComponentScan(basePackages = {"Repositories"})

public class CalculadoraCaloriasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraCaloriasApplication.class, args);
	}

}
