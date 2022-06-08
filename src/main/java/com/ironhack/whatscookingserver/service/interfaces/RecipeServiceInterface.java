package com.ironhack.whatscookingserver.service.interfaces;

import com.ironhack.whatscookingserver.models.Recipe;

import java.util.List;

public interface RecipeServiceInterface {
    void saveRecipe(Recipe recipeDTO);

    List<Recipe> getOriginalRecipes();

    Recipe findById(Long id);

    void update(Long id, Recipe recipe);

    void deleteRecipe(Long id);
}
