package com.ironhack.whatscookingserver.repository;

import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    public List<Recipe> findByTitleContains(String string);

    public List<Recipe> findByIngredientsContains(String string);
}
