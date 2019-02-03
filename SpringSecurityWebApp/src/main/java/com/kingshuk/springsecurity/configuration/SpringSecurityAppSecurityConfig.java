package com.kingshuk.springsecurity.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SpringSecurityAppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*auth.inMemoryAuthentication()
                .withUser("rishi2616").password("Password-1").roles("EMPLOYEE")
                .and()
                .withUser("deeksha123").password("Password-2").roles("LEADERSHIP")
                .and()
                .withUser("rishi1626").password("Password-3").roles("VENDOR");*/

        UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("rishi2616").password("Password-1").roles("EMPLOYEE"))
                .withUser(userBuilder.username("deeksha123").password("Password-2").roles("LEADERSHIP"))
                .withUser(userBuilder.username("rishi1626").password("Password-3").roles("VENDOR"));
    }

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
