package com.kingshuk.springsecurity.model;

import com.kingshuk.springsecurity.model.entities.RegistrationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistrationDAO {

    @Autowired
    private UserDetailsManager userDetailsManager;


    public void processRegistration(RegistrationData registrationData) {
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        //Encrypt the password
        String finalPassword = "{noop}" + passwordEncoder.encode(registrationData.getPassword());

        //Creating a string array out of a list
        String [] roles= registrationData.getRoles().toArray(new String[0]);

        //prepare the list of roles
        List<GrantedAuthority> accessRoles = AuthorityUtils
                .createAuthorityList(roles);

        //Create a user object
        User user = new User(registrationData.getUsername(),
                finalPassword,
                accessRoles);

        //Save the user to the database
        userDetailsManager.createUser(user);
    }

    public boolean checkIfUserExists(String userId) {
        return userDetailsManager.userExists(userId);
    }
}
