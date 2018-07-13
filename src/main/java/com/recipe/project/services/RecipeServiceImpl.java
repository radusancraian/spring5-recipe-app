
package com.recipe.project.services;

import com.recipe.project.domain.Recipe;
import com.recipe.project.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe getRecipeList(String name) {
        return recipeRepository.findByName(name);
    }
}

