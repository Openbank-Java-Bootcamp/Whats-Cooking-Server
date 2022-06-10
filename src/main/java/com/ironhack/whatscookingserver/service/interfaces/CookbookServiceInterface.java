package com.ironhack.whatscookingserver.service.interfaces;

import com.ironhack.whatscookingserver.DTO.UpdateCookbookDTO;
import com.ironhack.whatscookingserver.models.Cookbook;
import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.models.User;

import java.util.List;

public interface CookbookServiceInterface {

    void saveCookbook(User owner);

    Cookbook findById(Long id);

//    void update(Long id, Cookbook cookbook);

    //void addRecipeToCookbook(Long cookbookId, Recipe recipe);

    //void addRecipeToCookbook(Long cookbookId, Long recipeId);

    //void addRecipeToCookbook(UpdateCookbookDTO updateCookbookDTO);

    void update(Long cookbookId, List<Recipe> recipeList);

    void removeRecipeFromCookbook(Long cookbookId, Recipe recipe);
}
