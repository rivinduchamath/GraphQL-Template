package com.cloudofgoods.authservice.configaration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
public class SwaggerConfig {
    private static final String SECURITY_REFERENCE = "Token Access";
    private static final String AUTHORIZATION_DESCRIPTION = "Token Access";
    private static final String AUTHORIZATION_SCOPE = "Token Access";
    private static final String CONTACT_EMAIL = "Token Access";
    private static final String CONTACT_URL = "Token Access";
    private static final String CONTACT_NAME = "Token Access";
    private static final String API_TITLE = "Token Access";
    private static final String API_DESCRIPTION = "Token Access <a target='_blank' href=\"http://localhost:20023/login\"> here </a>";
    private static final String TERM_OF_SERVICE = "Token Access";
    private static final String API_VERSION = "Token Access";
    private static final String LICENSE = "Token Access";
    private static final String LICENSE_URL = "Token Access";
    private static final String SECURE_PATH = "Token Access";
    private static final String API_TAG = "Token Access";


    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(API_TITLE, API_DESCRIPTION, API_VERSION, TERM_OF_SERVICE, contact(),
                LICENSE, LICENSE_URL, Collections.emptyList());
    }

    private Contact contact() {
        return new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL);
    }

/*    private ApiKey apiKey (){
        return new ApiKey(SECURITY_REFERENCE, AUTHORIZATION , SecurityScheme.In.HEADER.name());
    }*/

    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(securityRefarance()).build();
    }

    private List<SecurityReference> securityRefarance() {
        AuthorizationScope[] authorizationScopes = { new AuthorizationScope(AUTHORIZATION_SCOPE, AUTHORIZATION_DESCRIPTION)};
        return  singletonList(new SecurityReference(SECURITY_REFERENCE,authorizationScopes));
    }
}
