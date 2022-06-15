package com.ironhack.whatscookingserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCookbookDTO {
    @NotNull
    private Long recipeId;
}

//need this to send the recipeId in a request body to add/remove a recipe from a cookbook
