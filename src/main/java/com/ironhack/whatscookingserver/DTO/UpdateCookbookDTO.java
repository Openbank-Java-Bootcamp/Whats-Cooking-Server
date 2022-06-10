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
    private Long cookbookId;
    @NotNull
    private Long recipeId;
}
