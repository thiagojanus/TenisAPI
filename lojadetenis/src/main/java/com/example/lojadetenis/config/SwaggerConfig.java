package com.example.lojadetenis.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
    return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.example.lojadetenis"))
                    .paths(PathSelectors.regex("/api.*"))
                    .build()
                    .apiInfo(metaInfo());
    }
    
    private ApiInfo metaInfo(){
        @SuppressWarnings("rawtypes")
        ApiInfo apiInfo = new ApiInfo(
            "Tênis API REST",
            "API REST para gerenciar a loja de tênis",
            "1.0",
            "Terms of Service",
            new Contact("Thiago Januario da Silva", "github.com/thiagojanus", "thiago.silva@lojatenis.com"),
            "Apache License Version 2.0",
            "https://www.apache.org/license.html",
            new ArrayList<VendorExtension>());
        return apiInfo;
    }
}