package com.ironhack.whatscookingserver.service.interfaces;

import com.ironhack.whatscookingserver.models.Cookbook;
import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.models.User;

import java.util.List;

public interface CookbookServiceInterface {

    void saveCookbook(User owner);

    Cookbook findById(Long id);

    void update(Long cookbookId, Long recipeId);
}
