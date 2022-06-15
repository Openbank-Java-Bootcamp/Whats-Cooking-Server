package com.ironhack.whatscookingserver.controller;

import com.ironhack.whatscookingserver.DTO.RecipeDTO;
import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.service.interfaces.RecipeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {

    @Autowired
    private RecipeServiceInterface recipeService;


    @PostMapping("/recipes")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRecipe(@RequestBody RecipeDTO recipeDTO) {
        recipeService.saveRecipe(recipeDTO);
    }

    @GetMapping("/recipes")
    @ResponseStatus(HttpStatus.OK)
    public List<Recipe> getRecipes() {
        return recipeService.getRecipes();
    }

    @GetMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.findById(id);
    }

    @GetMapping("/recipes/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Recipe> getRecipesByTitleOrIngredient(@RequestParam String query) {
        return recipeService.findByTitleOrIngredient(query);
    }

    @PutMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRecipe(@PathVariable Long id, @RequestBody @Valid Recipe recipe, Authentication authentication) {
        recipeService.updateRecipe(id, recipe, authentication);
    }


    @DeleteMapping("/recipes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long id, Authentication authentication) {
        recipeService.deleteRecipe(id, authentication);
    }
}
