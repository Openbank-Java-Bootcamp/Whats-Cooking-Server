package com.ironhack.whatscookingserver.service.interfaces;

import com.ironhack.whatscookingserver.models.Cookbook;

public interface CookbookServiceInterface {

    Cookbook getById(Long id);

    void update(Long id, Cookbook cookbook);
}
