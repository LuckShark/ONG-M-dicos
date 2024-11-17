package com.example.lucasigor.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Médicos Internos")
                        .version("1.0")
                        .description("API para gerenciamento de médicos voluntários e ONG parceiras")
                );
    }

}
