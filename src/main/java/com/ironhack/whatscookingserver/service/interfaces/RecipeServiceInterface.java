package com.ironhack.whatscookingserver.service.interfaces;

import com.ironhack.whatscookingserver.DTO.RecipeDTO;
import com.ironhack.whatscookingserver.models.Recipe;

import java.util.List;

public interface RecipeServiceInterface {
    void saveRecipe(RecipeDTO recipeDTO);

    List<Recipe> getRecipes();

    Recipe findById(Long id);

    List<Recipe> findByTitleOrIngredient(String query);

    void updateRecipe(Long id, Recipe recipe);

    //void updateRecipe(Long id, RecipeDTO recipeDTO);

    void deleteRecipe(Long id);
}
