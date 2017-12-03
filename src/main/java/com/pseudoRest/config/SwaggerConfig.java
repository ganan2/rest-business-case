package com.pseudoRest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Swagger 2 is enabled through the @EnableSwagger2 annotation. After the Docket bean is defined,
     * its select() method returns an instance of ApiSelectorBuilder,
     * which provides a way to control the endpoints exposed by Swagger.
     * Predicates for selection of RequestHandlers can be configured with the help of RequestHandlerSelectors and PathSelectors.
     * Using any() for both will make documentation for your entire API available through Swagger.
     * This configuration is enough to integrate Swagger 2 into existing Spring Boot project.
     * For other Spring projects, some additional tuning is required.
     *
     * http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
     *
     * @return
     */
    @Bean
    public Docket swaggerApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
