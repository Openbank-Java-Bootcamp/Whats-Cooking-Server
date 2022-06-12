package com.ironhack.whatscookingserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "recipe_id")
//    private Recipe recipe;

//    @NotNull
//    private Long authorId;
//
    @NotNull
    private Long recipeId;

    @NotEmpty
    private String content;


//    public Note(Long authorId, Long recipeId, String content) {
//        this.authorId = authorId;
//        this.recipeId = recipeId;
//        this.content = content;
//    }


    public Note(User user, Long recipeId, String content) {
        this.user = user;
        this.recipeId = recipeId;
        this.content = content;
    }
}
