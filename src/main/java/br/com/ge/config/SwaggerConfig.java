package br.com.ge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.ge.resource")).paths(PathSelectors.any()).build()
				.apiInfo(this.apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("GE - Gerenciador de Estabelecimentos e Funcionários.")
				.description("API REST para gerenciar funcionários e estabelecimentos").version("1.0.0")
				.license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.contact(new Contact("Emerson Sousa", "https://www.linkedin.com/in/emersonsousapereira/",
						"sousap.emerson@gmail.com"))
				.build();
	}
}