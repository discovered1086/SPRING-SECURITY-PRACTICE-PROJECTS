package com.kingshuk.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.kingshuk.springsecurity")
public class SpringSecurityAppConfig implements WebMvcConfigurer {

    //Define a bean for the view resolver
    @Bean
    public ViewResolver defineViewResolver() {
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();

        resourceViewResolver.setPrefix("/pages/");

        resourceViewResolver.setSuffix(".jsp");

        return resourceViewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/style/**").addResourceLocations("/style/");
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }
}
