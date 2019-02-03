package com.kingshuk.springsecurity.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.List;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.kingshuk.springsecurity")
@PropertySource("classpath:database.properties")
public class SpringSecurityAppConfig implements WebMvcConfigurer {

    //Setting up a logger
    private final Logger logger = Logger.getLogger(getClass().getName());

    //Autowiring the environment property
    @Autowired
    private Environment environment;

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
        registry.addResourceHandler("/style/*").addResourceLocations("/style/");
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    /*@Bean
    public DataSource buildMyDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        try {
            logger.info("The JDBC driver name is " + environment.getProperty("jdbc.driver"));
            dataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        logger.info("The JDBC URL is " + environment.getProperty("jdbc.url"));
        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));

        logger.info("The user id is " + environment.getProperty("jdbc.user"));
        dataSource.setUser(environment.getProperty("jdbc.user"));

        logger.info("The password is " + environment.getProperty("jdbc.password"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));

        dataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));

        dataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));

        dataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));

        dataSource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));

        return dataSource;
    }*/

    @Bean
    public DataSource buildMyDataSource() {
        BasicDataSource dataSource = new BasicDataSource();


        logger.info("The JDBC driver name is " + environment.getProperty("jdbc.driver"));
        dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));


        logger.info("The JDBC URL is " + environment.getProperty("jdbc.url"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));

        logger.info("The user id is " + environment.getProperty("jdbc.user"));
        dataSource.setUsername(environment.getProperty("jdbc.user"));

        logger.info("The password is " + environment.getProperty("jdbc.password"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));

        dataSource.setInitialSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));

        dataSource.setMaxActive(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));

        //dataSource.set(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));

        dataSource.setMaxIdle(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));

        return dataSource;
    }


}
