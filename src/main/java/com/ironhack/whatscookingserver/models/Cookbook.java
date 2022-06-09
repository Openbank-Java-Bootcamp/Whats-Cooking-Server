package com.ironhack.whatscookingserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cookbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "cookbook_recipe",
            joinColumns = @JoinColumn(name = "cookbook_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> recipeList;


    public Cookbook(User owner) {
        //this.id = owner.getId();
        this.owner = owner;
        this.recipeList = new ArrayList<>();
    }

    //methods
    public void saveRecipeToCookbook(Recipe recipe) {
        List<Recipe> recipeList = this.getRecipeList();
        recipeList.add(recipe);
        setRecipeList(recipeList);
    }
}
