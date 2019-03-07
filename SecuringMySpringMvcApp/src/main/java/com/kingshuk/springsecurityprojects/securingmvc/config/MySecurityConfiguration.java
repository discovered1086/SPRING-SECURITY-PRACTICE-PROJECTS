package com.kingshuk.springsecurityprojects.securingmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}user").authorities("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		/**
		 * A quick note on using hasRole. If we use this method
		 * Then the roles will be prefixed with ROLE_ and i guess you remember this from
		 * Before, when we wrote the code for the other spring MVC applications
		 * 
		 * If we want to avoid that, we use hasAuthority instead of hasRole method
		 */
		//.antMatchers("/delete/**").hasRole("ADMIN")
		//.antMatchers("/delete/**").hasAuthority("ADMIN")
			.antMatchers("/delete/**").hasAuthority("ADMIN")
			.anyRequest().authenticated()
			.and()
		.formLogin().and()
		.httpBasic();
	}
	
	

}
