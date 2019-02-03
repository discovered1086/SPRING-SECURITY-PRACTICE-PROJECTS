package com.kingshuk.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityAppSecurityConfig extends WebSecurityConfigurerAdapter {

    //Inject the data source configured previously
    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //We no longer need to hard code user ids and passwords here
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    /*@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/style/*").anyRequest();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/style/*").permitAll();

        //The below code opens up at least the home page for everyone
        //http.authorizeRequests().antMatchers("/").permitAll();

        /**
         * Why the below block of code does not work for restricting access is because
         * it literally says any request coming from any authenticated user is allowed
         */
        /*http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/requestToLogin")
                    .loginProcessingUrl("/performLogin")
                    .successForwardUrl("/")
                    //.failureForwardUrl("/failedAuthentication")
                    .permitAll()
                .and()
                .logout().permitAll();
                */

        /*http.authorizeRequests()
                .antMatchers("/employee").hasRole("EMPLOYEE")
                .antMatchers("/leadership").hasRole("LEADERSHIP")
                .antMatchers("/vendor").hasRole("VENDOR")
                .and()
                .formLogin()
                    .loginPage("/requestToLogin")
                    .loginProcessingUrl("/performLogin")
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/failedAuthorization");
                */

        http.authorizeRequests()
                .antMatchers("/employee").hasRole("EMPLOYEE")
                .antMatchers("/leadership").hasRole("LEADERSHIP")
                .antMatchers("/vendor").hasRole("VENDOR")
                .antMatchers("/").hasAnyRole("EMPLOYEE","VENDOR","LEADERSHIP")
                .and()
                .formLogin()
                .loginPage("/requestToLogin")
                .loginProcessingUrl("/performLogin")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/failedAuthorization");



    }


}
