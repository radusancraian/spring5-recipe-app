package com.recipe.project.controllers;

import com.recipe.project.repositories.CategoryRepository;
import com.recipe.project.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public UnitOfMeasureRepository getUnitOfMeasureRepository() {
        return unitOfMeasureRepository;
    }

    public void setUnitOfMeasureRepository(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {


        return "index";
    }
}
