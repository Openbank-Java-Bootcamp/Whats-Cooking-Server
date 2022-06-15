package com.ironhack.whatscookingserver.service.interfaces;

import com.ironhack.whatscookingserver.DTO.RecipeDTO;
import com.ironhack.whatscookingserver.models.Recipe;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface RecipeServiceInterface {
    void saveRecipe(RecipeDTO recipeDTO);

    List<Recipe> getRecipes();

    Recipe findById(Long id);

    List<Recipe> findByTitleOrIngredient(String query);

    void updateRecipe(Long id, Recipe recipe, Authentication authentication);

    void deleteRecipe(Long id, Authentication authentication);
}
