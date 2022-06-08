package com.ironhack.whatscookingserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Provide a recipe name.")
    private String name;

    @Column(name = "prep_time")
    private int prepTime;

    @Column(name = "cook_time")
    private int cookTime;

    private int servings;

    private String ingredients;

    private String directions;

    @ManyToOne
    private User addedBy;

    @ManyToMany(mappedBy = "recipeList")
    private List<Cookbook> cookbooks;

    private boolean isOriginal;


    public Recipe(String name, int prepTime, int cookTime, int servings, String ingredients, String directions, User addedBy, List<Cookbook> cookbooks, boolean isOriginal) {
        this.name = name;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.ingredients = ingredients;
        this.directions = directions;
        this.addedBy = addedBy;
        this.cookbooks = cookbooks;
        this.isOriginal = isOriginal;
    }

}
