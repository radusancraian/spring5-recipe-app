package com.recipe.project.repositories;

import com.recipe.project.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
