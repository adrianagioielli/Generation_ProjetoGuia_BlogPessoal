package com.generation.blogPessoal.Configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI springBlogPessoalOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Projeto Blog Pessoal - Generation Brasil - Turma 66")
				.version("v0.0.1")
				.license(new License()
						.name("Generation Brasil")
						.url("http://brazil.generation.org/"))
				.contact(new Contact()
						.name("Adriana Gioielli")
						.url("https://github.com/adrianagioielli/")
						.email("adrianalves.cp@gmail.com")))
				.externalDocs(new ExternalDocumentation().description("GitHub").url("http://github.com/conteudoGeneration"));
	}
	
	private ApiResponse createApiResponse(String message) {
		return new ApiResponse().description(message);
	}
	
	@Bean
	public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
		return openApi -> {
			openApi.getPaths().values().forEach(pathItem ->pathItem.readOperations()
					.forEach(operation ->{
						ApiResponses apiResponses = operation.getResponses();
						apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
						apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
						apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
						apiResponses.addApiResponse("400", createApiResponse("Erro na Aquisição!"));
						apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
						apiResponses.addApiResponse("403", createApiResponse("Acesso Não Proibido!"));
						apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
						apiResponses.addApiResponse("401", createApiResponse("Erro Na Aplicação!"));
			}));
		};
	}	
}
