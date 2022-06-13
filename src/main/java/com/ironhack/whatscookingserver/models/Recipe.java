package com.ironhack.whatscookingserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    private String ingredients;

    @NotEmpty
    private String directions;

    @ManyToOne
    private User addedBy;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "recipeList")
//    private List<Cookbook> cookbooks;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Note> notes = new ArrayList<>();

    @Lob//specifies that column in db will be long text
    private String image;


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


    //METHODS
//    public void addCookbookToList(Cookbook cookbook) {
//        List<Cookbook> cookbooks = getCookbooks();
//        cookbooks.add(cookbook);
//        cookbook.addRecipeToCookbook(this);
//        setCookbooks(cookbooks);
//    }
//
//    public void removeCookbookFromList(Cookbook cookbook) {
//        List<Cookbook> cookbooks = getCookbooks();
//        cookbooks.remove(cookbook);
//        cookbook.removeRecipeFromCookbook(this);
//        setCookbooks(cookbooks);
//    }

}
