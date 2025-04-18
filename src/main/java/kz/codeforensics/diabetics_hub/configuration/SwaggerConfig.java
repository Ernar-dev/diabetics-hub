package kz.codeforensics.diabetics_hub.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
//    @Value("${http://diabetics-app:8080}")
//    private String host;
//    @Value("${open-api.description}")
//    private String description;
    @Bean
    public OpenAPI openApi() {
        final String securitySchemeName = "Authorization";
        return new OpenAPI()
                .info(new Info()
                        .title("diabetics-rest-v1")
                        .description("Сервисы для работы с Медицинская информационная система")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Amangeldi Ernar")
                                .url("https://diabetics.ru")
                                .email("damir.ydyrl@mail.ru"))
                        .termsOfService("CodeForensics")
                        .license(new License().name("License").url("#"))
                )
                .servers(List.of(new Server()
                        .url("http://diabetics-app:8080")
                        .description("Docker Environment")))
                .components(
                        new Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .type(SecurityScheme.Type.APIKEY)
                                                .in(SecurityScheme.In.HEADER)
                                                .name("Authorization")
                                )
                )
                .security(List.of(new SecurityRequirement().addList(securitySchemeName)));
    }

}
