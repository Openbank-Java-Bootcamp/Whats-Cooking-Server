package com.ironhack.whatscookingserver.service.impl;

import com.ironhack.whatscookingserver.DTO.RecipeDTO;
import com.ironhack.whatscookingserver.models.Cookbook;
import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.models.User;
import com.ironhack.whatscookingserver.repository.CookbookRepository;
import com.ironhack.whatscookingserver.repository.RecipeRepository;
import com.ironhack.whatscookingserver.repository.UserRepository;
import com.ironhack.whatscookingserver.service.interfaces.CookbookServiceInterface;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CookbookRepository cookbookRepository;

    public void saveRecipe(RecipeDTO recipeDTO) {
        log.info("Saving a new recipe {} inside of the database", recipeDTO.getTitle());
        //create new Recipe object and save to repo
        User user = userRepository.findById(recipeDTO.getUserId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Recipe recipe = new Recipe(recipeDTO.getTitle(), recipeDTO.getPrepTime(), recipeDTO.getCookTime(),
                recipeDTO.getServings(), recipeDTO.getIngredients(), recipeDTO.getDirections(),
                user, recipeDTO.getImage()) ;
        recipeRepository.save(recipe);
        log.info("Recipe saved to database");
        //save new recipe to user's cookbook
        log.info("Saving a new recipe {} inside of the cookbook", recipeDTO.getTitle());
        Cookbook userCookbook = cookbookRepository.findById(recipeDTO.getUserId()).get();
        userCookbook.addRecipeToCookbook(recipe);
        cookbookRepository.save(userCookbook);
        log.info("Recipe saved to cookbook");
    }

    public List<Recipe> getRecipes() {
        //List<Recipe> recipes = recipeRepository.findAll();
        return recipeRepository.findAll();
    }

    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found"));
    }

    public void updateRecipe(Long id, RecipeDTO recipeDTO) {
        Recipe recipeFromDB = recipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found"));
        System.out.println(recipeDTO);
        recipeFromDB.setTitle(recipeDTO.getTitle());
        recipeFromDB.setPrepTime(recipeDTO.getPrepTime());
        recipeFromDB.setCookTime(recipeDTO.getCookTime());
        recipeFromDB.setServings(recipeDTO.getServings());
        recipeFromDB.setIngredients(recipeFromDB.getIngredients());
        recipeFromDB.setDirections(recipeFromDB.getDirections());
        //recipeFromDB.setImage(recipeFromDB.getImage());
        recipeRepository.save(recipeFromDB);
    }

    public void deleteRecipe(Long id) {
        Recipe recipeFromDB = recipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found"));
        List<Cookbook> connectedCookbooks = recipeFromDB.getCookbooks();
        connectedCookbooks.forEach((cookbook) -> {
            recipeFromDB.removeCookBook(cookbook);
            cookbookRepository.save(cookbook);
        });
        recipeRepository.save(recipeFromDB);
        recipeRepository.delete(recipeFromDB);
    }
}
