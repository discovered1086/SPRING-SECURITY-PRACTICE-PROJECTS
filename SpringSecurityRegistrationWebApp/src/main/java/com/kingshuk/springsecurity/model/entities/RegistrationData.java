package com.kingshuk.springsecurity.model.entities;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class RegistrationData {

    @NotEmpty(message="User ID can't be empty")
    private String username;

    @NotEmpty(message="Password can't be empty")
    private String password;

    @NotEmpty(message = "You have to select at least one role")
    private List<String> roles;

    public RegistrationData() {
        roles=new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
