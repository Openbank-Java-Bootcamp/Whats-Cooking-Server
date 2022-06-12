package com.ironhack.whatscookingserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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
}
