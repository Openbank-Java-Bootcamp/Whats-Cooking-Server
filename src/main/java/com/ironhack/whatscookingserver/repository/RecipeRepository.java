package com.ironhack.whatscookingserver.repository;

import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {


    @Query(value="SELECT * FROM recipe WHERE recipe.title LIKE :query OR recipe.ingredients LIKE :query", nativeQuery = true)
    public List<Recipe> findByIngredientsOrDirectionsContains(String query);
}
