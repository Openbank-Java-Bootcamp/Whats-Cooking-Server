package com.ironhack.whatscookingserver.service.interfaces;

import com.ironhack.whatscookingserver.models.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User userSignupDTO) throws Exception;

    List<User> getUsers();

    void deleteUser(Long userId);
}
