package com.ironhack.whatscookingserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
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
    private String title;

    @Column(name = "prep_time")
    private int prepTime;

    @Column(name = "cook_time")
    private int cookTime;

    private int servings;

    @NotEmpty
    @Lob
    private String ingredients;

    @NotEmpty
    @Lob
    private String directions;

    @ManyToOne
    private User addedBy;

    @JsonIgnore
    @ManyToMany(mappedBy = "recipeList")
    private List<Cookbook> cookbooks = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Note> notes = new ArrayList<>();


    @Lob//specifies that column in db will be long text
    private String image;


    public Recipe(String title, int prepTime, int cookTime, int servings, String ingredients, String directions, String image) {
        this.title = title;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.ingredients = ingredients;
        this.directions = directions;
        this.image = image;
    }

    //need this for POST request to save new recipe
    public Recipe(String title, int prepTime, int cookTime, int servings, String ingredients, String directions, User addedBy, String image) {
        this.title = title;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.ingredients = ingredients;
        this.directions = directions;
        this.addedBy = addedBy;
        this.image = image;
    }

    //need this for PUT request to update recipe
    public Recipe(String title, int prepTime, int cookTime, int servings, String ingredients, String directions, List<Cookbook> cookbooks, List<Note> notes) {
        this.title = title;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.ingredients = ingredients;
        this.directions = directions;
        this.cookbooks = cookbooks;
        this.notes = notes;
    }

    //Need this one for the command line runner
    public Recipe(String title, int prepTime, int cookTime, int servings, String ingredients, String directions, User addedBy) {
        this.title = title;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.ingredients = ingredients;
        this.directions = directions;
        this.addedBy = addedBy;
    }

    //METHODS
    public void addCookbook(Cookbook cookbook) {
        List<Cookbook> cookbooks = this.getCookbooks();
        cookbooks.add(cookbook);
        this.setCookbooks(cookbooks);

        List<Recipe> recipes = cookbook.getRecipeList();
        recipes.add(this);
        cookbook.setRecipeList(recipes);
    }

    public void removeCookBook(Cookbook cookbook) {
        List<Cookbook> cookbooks = this.getCookbooks();
        cookbooks.remove(this);
        this.setCookbooks(cookbooks);

        List<Recipe> recipes = cookbook.getRecipeList();
        recipes.remove(this);
        cookbook.setRecipeList(recipes);
    }

}
