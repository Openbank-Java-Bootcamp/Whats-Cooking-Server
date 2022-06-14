package com.ironhack.whatscookingserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCookbookDTO {
    private Long recipeId;
}

//need this to send the recipeId in a request body to add/remove a recipe from a cookbook
