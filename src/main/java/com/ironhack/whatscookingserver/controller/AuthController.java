package com.ironhack.whatscookingserver.controller;

import com.google.gson.Gson;
import com.ironhack.whatscookingserver.DTO.UserVerifyDTO;
import com.ironhack.whatscookingserver.models.User;
import com.ironhack.whatscookingserver.repository.UserRepository;
import com.ironhack.whatscookingserver.service.impl.UserService;
import com.ironhack.whatscookingserver.service.interfaces.CookbookServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Slf4j
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private CookbookServiceInterface cookbookService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/auth/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Valid User user) throws Exception {
       return userService.saveUser(user);
    }

    //if a user re-enters the app and the token is still valid, user will not need to login again
    @GetMapping("/auth/verify")
    @ResponseStatus(HttpStatus.OK)
    public String verifyToken(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByEmail(email);
        UserVerifyDTO userVerifyDTO = new UserVerifyDTO(userFromDb.getId(), userFromDb.getName());
        Gson gson = new Gson();
        String userDetails = gson.toJson(userVerifyDTO);
        return userDetails;
    }
}
