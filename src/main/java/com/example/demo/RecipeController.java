package com.example.demo;


import com.example.demo.Recipe;
import com.example.demo.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin(origins = "*")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public Page<Recipe> getAllRecipes(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int limit) {
        return recipeService.getAllRecipes(page, limit);
    }

    @GetMapping("/search")
    public List<Recipe> searchRecipes(@RequestParam(required = false) String title,
                                      @RequestParam(required = false) String cuisine) {
        return recipeService.searchRecipes(title, cuisine);
    }
}

