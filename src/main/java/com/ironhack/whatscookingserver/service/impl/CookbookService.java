package com.ironhack.whatscookingserver.service.impl;

import com.ironhack.whatscookingserver.models.Cookbook;
import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.repository.CookbookRepository;
import com.ironhack.whatscookingserver.service.interfaces.CookbookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CookbookService implements CookbookServiceInterface {

    @Autowired
    CookbookRepository cookbookRepository;


    public Cookbook getById(Long id) {
        return cookbookRepository.getReferenceById(id);
    }

    public void update(Long id, Cookbook cookbook) {
        Cookbook cookbookFromDB = cookbookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cookbook not found"));
        cookbook.setId(cookbookFromDB.getId());
        cookbookRepository.save(cookbook);
    }
}
