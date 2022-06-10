package com.ironhack.whatscookingserver.service.impl;

import com.ironhack.whatscookingserver.DTO.UpdateCookbookDTO;
import com.ironhack.whatscookingserver.models.Cookbook;
import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.models.User;
import com.ironhack.whatscookingserver.repository.CookbookRepository;
import com.ironhack.whatscookingserver.repository.RecipeRepository;
import com.ironhack.whatscookingserver.service.interfaces.CookbookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CookbookService implements CookbookServiceInterface {

    @Autowired
    CookbookRepository cookbookRepository;

    @Autowired
    RecipeRepository recipeRepository;


    public void saveCookbook(User owner) {
        Cookbook cookbook = new Cookbook(owner.getId(), owner);
        cookbookRepository.save(cookbook);
    }

    public Cookbook findById(Long id) {
        return cookbookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cookbook not found"));
    }

//    public void update(Long id, Cookbook cookbook) {
//        Cookbook cookbookFromDB = cookbookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cookbook not found"));
//        cookbook.setId(cookbookFromDB.getId());
//        cookbookRepository.save(cookbook);
//    }

//    public void addRecipeToCookbook(Long cookbookId, Recipe recipe) {
//        Cookbook cookbookFromDB = cookbookRepository.findById(cookbookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cookbook not found"));
//        recipe.addCookbookToList(cookbookFromDB);
//        recipeRepository.save(recipe);
//        cookbookRepository.save(cookbookFromDB);
//    }

//    public void addRecipeToCookbook(UpdateCookbookDTO updateCookbookDTO) {
//        Long cookbookId = updateCookbookDTO.getCookbookId();
//        Long recipeId = updateCookbookDTO.getRecipeId();
//        Cookbook cookbookFromDB = cookbookRepository.findById(cookbookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cookbook not found"));
//        Recipe recipeFromDB = recipeRepository.findById(recipeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Recipe not found"));
//        recipeFromDB.addCookbookToList(cookbookFromDB);
//        recipeRepository.save(recipeFromDB);
//        cookbookRepository.save(cookbookFromDB);
//    }

    public void update(Long cookbookId, List<Recipe> recipeList) {
        Cookbook cookbookFromDB = cookbookRepository.findById(cookbookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cookbook not found"));
        cookbookFromDB.setRecipeList(recipeList);
        cookbookRepository.save(cookbookFromDB);
    }

    public void removeRecipeFromCookbook(Long cookbookId, Recipe recipe) {
        Cookbook cookbookFromDB = cookbookRepository.findById(cookbookId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cookbook not found"));
        recipe.removeCookbookFromList(cookbookFromDB);
        recipeRepository.save(recipe);
        cookbookRepository.save(cookbookFromDB);
    }
}
