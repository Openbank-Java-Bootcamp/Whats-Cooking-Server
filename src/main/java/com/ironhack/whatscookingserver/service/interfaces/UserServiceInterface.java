package com.ironhack.whatscookingserver.service.interfaces;

import com.ironhack.whatscookingserver.models.User;


public interface UserServiceInterface {
    User saveUser(User userSignupDTO) throws Exception;

    void deleteUser(Long userId);
}
