package com.riwi.simulacro_prueba_spring_boot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration // Para meter el frijol dentro de la lata a que esto es algo por fuera de Spring Boot
@OpenAPIDefinition(
        info = @Info(
                title = "Application to manage Riwi's online learning platform.",
                version = "1.0",
                description = "EndPoint documentation of the simulacro pring boot aplication"
        )
)
public class OpenApiConfiguration {

}
