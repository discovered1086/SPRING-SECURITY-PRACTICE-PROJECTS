package com.kingshuk.springsecurityprojects.securingmvc.persistence;

import com.kingshuk.springsecurityprojects.securingmvc.model.User;

public interface UserRepository {

    Iterable<User> findAll();

    User save(User user);

    User findUser(Long id);

    void deleteUser(Long id);

}
