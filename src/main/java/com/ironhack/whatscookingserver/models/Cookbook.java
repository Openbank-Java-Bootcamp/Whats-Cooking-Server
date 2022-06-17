package com.ironhack.whatscookingserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;

    @OneToOne
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "cookbook_recipe",
            joinColumns = @JoinColumn(name = "cookbook_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> recipeList = new ArrayList<>();



    public Cookbook(Long id, User owner) {
        this.id = id;
        this.owner = owner;
    }

    //methods
    public void addRecipeToCookbook(Recipe recipe) {
        List<Recipe> recipeList = this.getRecipeList();
        recipeList.add(recipe);
        setRecipeList(recipeList);
    }

}
