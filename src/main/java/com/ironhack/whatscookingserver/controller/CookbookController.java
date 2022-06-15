package com.ironhack.whatscookingserver.controller;

import com.ironhack.whatscookingserver.DTO.UpdateCookbookDTO;
import com.ironhack.whatscookingserver.models.Cookbook;
import com.ironhack.whatscookingserver.repository.UserRepository;
import com.ironhack.whatscookingserver.service.interfaces.CookbookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class CookbookController {

    @Autowired
    CookbookServiceInterface cookbookService;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/cookbooks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cookbook getCookbookById(@PathVariable Long id) {
        return cookbookService.findById(id);
    }


    //to add or remove a recipe to a cookbook
    @PatchMapping("/cookbooks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCookbook(@PathVariable(name="id") Long cookbookId, @RequestBody @Valid UpdateCookbookDTO updateCookbookDTO, Authentication authentication) {
        cookbookService.update(cookbookId, updateCookbookDTO.getRecipeId(), authentication);
    }


}
