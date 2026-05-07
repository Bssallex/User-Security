package com.bssallex.usersecurity.docs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI getOpenAPI() {

        Contact contact = new Contact();
        contact.name("Alex Bruno");
        contact.email("BssallexPC@gmail.com");

        Info info = new Info();
        info.title("UserSecurity");
        info.version("v1");
        info.description("Api para cadastro de usuário via Oauth2 e JWT");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}
