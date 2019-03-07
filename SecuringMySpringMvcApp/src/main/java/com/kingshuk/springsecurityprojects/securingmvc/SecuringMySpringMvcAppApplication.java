package com.kingshuk.springsecurityprojects.securingmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import com.kingshuk.springsecurityprojects.securingmvc.model.User;
import com.kingshuk.springsecurityprojects.securingmvc.persistence.InMemoryUserRepository;
import com.kingshuk.springsecurityprojects.securingmvc.persistence.UserRepository;

@SpringBootApplication
public class SecuringMySpringMvcAppApplication {
	
	@Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

	@Bean
    public Converter<String, User> messageConverter() {
        return new Converter<String, User>() {
            @Override
            public User convert(String id) {
                return userRepository().findUser(Long.valueOf(id));
            }
        };
    }
	public static void main(String[] args) {
		SpringApplication.run(SecuringMySpringMvcAppApplication.class, args);
	}

}
