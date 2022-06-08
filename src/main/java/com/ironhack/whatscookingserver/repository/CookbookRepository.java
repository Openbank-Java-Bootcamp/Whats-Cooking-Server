package com.ironhack.whatscookingserver.repository;

import com.ironhack.whatscookingserver.models.Cookbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookbookRepository extends JpaRepository<Cookbook, Long> {
}
