package com.recipe.project.repositories;

import com.recipe.project.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    UnitOfMeasure findByDescription(String description);
}
