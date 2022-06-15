package com.ironhack.whatscookingserver.service.impl;

import com.ironhack.whatscookingserver.models.Cookbook;
import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.models.User;
import com.ironhack.whatscookingserver.repository.CookbookRepository;
import com.ironhack.whatscookingserver.repository.RecipeRepository;
import com.ironhack.whatscookingserver.repository.UserRepository;
import com.ironhack.whatscookingserver.service.interfaces.CookbookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CookbookService implements CookbookServiceInterface {

    @Autowired
    private CookbookRepository cookbookRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;


    public void saveCookbook(User owner) {
        Cookbook cookbook = new Cookbook(owner.getId(), owner);
        cookbookRepository.save(cookbook);
    }

    public Cookbook findById(Long id) {
        return cookbookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cookbook not found"));
    }


    public void update(Long cookbookId, Long recipeId, Authentication authentication) {
        //verify that user is the cookbook owner
        String email = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByEmail(email);
        Cookbook cookbookFromDB = cookbookRepository.findById(cookbookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cookbook not found"));

        if (userFromDb != cookbookFromDB.getOwner()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User not authorized for this request.");
        } else {
            //get recipe from database
            Recipe recipeFromDb = recipeRepository.findById(recipeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found"));
            List<Recipe> recipesList = cookbookFromDB.getRecipeList();

            //check if recipe already exists in the cookbook's recipeList and then add or remove the recipe, this will update the relationship on both ends
            if (recipesList.contains(recipeFromDb)) {
                recipeFromDb.removeCookBook(cookbookFromDB);
            } else {
                recipeFromDb.addCookbook(cookbookFromDB);
            }
            //save both objects so the change in relationship is sent to the database
            recipeRepository.save(recipeFromDb);
            cookbookRepository.save(cookbookFromDB);
        }
    }

}
