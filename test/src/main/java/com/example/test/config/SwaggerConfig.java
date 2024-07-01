package com.example.test.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI PersonnalisationOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("basicScheme",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("basic")
                        ))
                .addSecurityItem(new SecurityRequirement().addList("basicScheme"))
                .info(new Info()
                        .title("Gestion de Ticket")
                        .description("Le système de gestion de tickets est une application informatique permettant aux apprenants de soumettre des demandes d'assistance personnalisée ou des questions spécifiques. Les formateurs peuvent alors traiter ces demandes de manière organisée et systématique.")
                        .version("1.0")
                        .contact(new Contact().name("THERA Badra").email("badrathera7@gmail.com"))
                );
    }
}
