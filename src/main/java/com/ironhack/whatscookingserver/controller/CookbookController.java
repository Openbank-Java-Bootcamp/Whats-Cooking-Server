package com.ironhack.whatscookingserver.controller;

import com.ironhack.whatscookingserver.models.Cookbook;
import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.service.interfaces.CookbookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CookbookController {

    @Autowired
    CookbookServiceInterface cookbookService;


    @GetMapping("/cookbooks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cookbook getCookbookById(@PathVariable Long id) {
        return cookbookService.findById(id);
    }

    @PutMapping("/cookbooks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCookbook(@PathVariable Long id, @RequestBody Cookbook cookbook) {
        cookbookService.update(id, cookbook);
    }

//    @PatchMapping("/cookbooks/add-recipe/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void addRecipeToCookbook(@PathVariable Long id, @RequestBody Recipe recipe) {
//        cookbookService.addRecipeToCookbook(id, recipe);
//    }

    @PatchMapping("/cookbooks/add-recipe/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRecipeToCookbook(@PathVariable(name="id") Long cookbookId, @RequestParam Long recipeId) {
        cookbookService.addRecipeToCookbook(cookbookId, recipeId);
    }

    @PatchMapping("/cookbooks/remove-recipe/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeRecipeFromCookbook(@PathVariable Long id, @RequestBody Recipe recipe) {
        cookbookService.removeRecipeFromCookbook(id, recipe);
    }

}
