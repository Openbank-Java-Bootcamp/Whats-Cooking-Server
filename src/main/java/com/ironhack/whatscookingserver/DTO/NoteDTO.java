package com.ironhack.whatscookingserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {
    private Long userId;
    private Long recipeId;
    private String content;
}

//for creating a new note