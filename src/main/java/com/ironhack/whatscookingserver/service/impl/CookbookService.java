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

    public void update(Long cookbookId, List<Recipe> recipeList) {
        Cookbook cookbookFromDB = cookbookRepository.findById(cookbookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cookbook not found"));
        cookbookFromDB.setRecipeList(recipeList);
        cookbookRepository.save(cookbookFromDB);
    }

//    public void update(Long cookbookId, Recipe recipe) {
//        Cookbook cookbookFromDB = cookbookRepository.findById(cookbookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cookbook not found"));
//        List<Recipe> recipesList = cookbookFromDB.getRecipeList();
//        if (recipesList.contains(recipe)) {
//            recipesList.remove(recipe);
//        } else {
//            recipesList.add(recipe);
//        }
//        cookbookFromDB.setRecipeList(recipesList);
//        cookbookRepository.save(cookbookFromDB);
//    }

}
