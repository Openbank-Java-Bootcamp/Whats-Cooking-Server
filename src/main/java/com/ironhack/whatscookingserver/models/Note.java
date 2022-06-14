package com.ironhack.whatscookingserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long userId;

    @NotNull
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @NotEmpty
    @Size(max = 150)
    private String content;


    public Note(Long userId, Recipe recipe, String content) {
        this.userId = userId;
        this.recipe = recipe;
        this.content = content;
    }
}
