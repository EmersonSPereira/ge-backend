package br.com.ge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = LiquibaseAutoConfiguration.class)

public class GerenciadorDeEmpresasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDeEmpresasApplication.class, args);
	}

}
