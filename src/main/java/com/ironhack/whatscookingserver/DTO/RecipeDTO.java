package com.ironhack.whatscookingserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {
    private String title;
    private int prepTime;
    private int cookTime;
    private int servings;
    private String ingredients;
    private String directions;
    private Long userId;
    private String image;

    public RecipeDTO(String title, int prepTime, int cookTime, int servings, String ingredients, String directions, Long userId) {
        this.title = title;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.ingredients = ingredients;
        this.directions = directions;
        this.userId = userId;
    }

}
