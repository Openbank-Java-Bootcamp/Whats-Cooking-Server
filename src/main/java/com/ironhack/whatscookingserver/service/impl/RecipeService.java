package com.ironhack.whatscookingserver.service.impl;

import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.repository.RecipeRepository;
import com.ironhack.whatscookingserver.service.interfaces.RecipeServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RecipeService implements RecipeServiceInterface {

    @Autowired
    private RecipeRepository recipeRepository;

    public void saveRecipe(Recipe recipeDTO) {
        log.info("Saving a new recipe {} inside of the database", recipeDTO.getTitle());
        Recipe recipe = new Recipe(recipeDTO.getTitle(), recipeDTO.getPrepTime(), recipeDTO.getCookTime(),
                recipeDTO.getServings(), recipeDTO.getIngredients(), recipeDTO.getDirections(),
                recipeDTO.getAddedBy());
        recipeRepository.save(recipe);
    }

    public List<Recipe> getRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();

//        List<Recipe> originalRecipes = recipes.stream().filter(recipe ->
//                recipe.isOriginal()).collect(Collectors.toList());
        return recipes;
    }

    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found"));
    }

    public void update(Long id, Recipe recipe) {
        Recipe recipeFromDB = recipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found"));
        recipe.setId(recipeFromDB.getId());
        recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}
