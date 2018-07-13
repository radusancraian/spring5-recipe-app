package com.recipe.project.repositories;

import com.recipe.project.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

    Recipe findByName(String name);
}
