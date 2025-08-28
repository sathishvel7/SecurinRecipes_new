package com.example.demo;


import com.example.demo.Recipe;
import com.example.demo.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public Page<Recipe> getAllRecipes(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("rating").descending());
        return recipeRepository.findAll(pageable);
    }

    public List<Recipe> searchRecipes(String title, String cuisine) {
        if (title != null) return recipeRepository.findByTitleContainingIgnoreCase(title);
        if (cuisine != null) return recipeRepository.findByCuisineContainingIgnoreCase(cuisine);
        return recipeRepository.findAll();
    }
}

