package com.geocom.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {

    @Value("${com.geocom.cors.allowedorigins}")
    private String[] allowedOrigins;

    @Value("${com.geocom.cors.allowedmethods}")
    private String[] allowedMethods;

    @Value("${com.geocom.cors.urlmappings}")
    private String urlMappings;

    @Value("${com.geocom.cors.maxage}")
    private long maxAge;


    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping(urlMappings)
                .allowedMethods(allowedMethods)
                .allowedOrigins(allowedOrigins)
                .maxAge(maxAge);

    }
}
