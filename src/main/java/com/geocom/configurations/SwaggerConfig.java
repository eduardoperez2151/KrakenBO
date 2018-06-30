package com.geocom.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${com.geocom.api.docs.basepackage}")
    private String swaggerBasePackageControllers;

    @Value("${com.geocom.api.docs.title}")
    private String restApiTitle;

    @Value("${com.geocom.api.docs.description}")
    private String description;

    @Value("${com.geocom.api.docs.version}")
    private String restApiVersion;

    @Value("${com.geocom.api.docs.termofservice}")
    private String termsOfService;

    @Value("${com.geocom.api.docs.license}")
    private String license;

    @Value("${com.geocom.api.docs.license.url}")
    private String licenseUrl;

    @Value("${com.geocom.api.docs.contact.name}")
    private String contactName;

    @Value("${com.geocom.api.docs.contact.url}")
    private String contactUrl;

    @Value("${com.geocom.api.docs.contact.email}")
    private String contactEmail;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerBasePackageControllers))
                .paths(PathSelectors.any())
                .build()
                .consumes(Stream.of("application/json").collect(Collectors.toSet()))
                .produces(Stream.of("application/json").collect(Collectors.toSet()))
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {

        return new ApiInfo(
                restApiTitle,
                description,
                restApiVersion,
                termsOfService,
                new Contact(contactName, contactUrl, contactEmail),
                license,
                licenseUrl, new ArrayList<>());
    }
}   
