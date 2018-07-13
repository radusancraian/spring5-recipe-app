package com.recipe.project.bootstrap;

import com.recipe.project.domain.*;
import com.recipe.project.repositories.CategoryRepository;
import com.recipe.project.repositories.IngredientRepository;
import com.recipe.project.repositories.RecipeRepository;
import com.recipe.project.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;


    public DevBootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    public void initData() {


        Recipe guacamolePerfectRecipe = new Recipe();
        Set<Ingredient> guacamoleIngredients = new HashSet<>();
        guacamolePerfectRecipe.setName("guacamole");

       UnitOfMeasure ripe = unitOfMeasureRepository.findByDescription("Ripe");
       UnitOfMeasure teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
       UnitOfMeasure tableSpoon = unitOfMeasureRepository.findByDescription("Tablespoon");
       UnitOfMeasure dash = unitOfMeasureRepository.findByDescription("Dash");

        Ingredient avocado = new Ingredient("avocado", guacamolePerfectRecipe, 2, ripe);
        Ingredient kosherSalt = new Ingredient("kosherSalt", guacamolePerfectRecipe, 1/2, null);
        Ingredient limeJuice = new Ingredient("limeJuice", guacamolePerfectRecipe, 1, tableSpoon);
        Ingredient mincedRedOnion = new Ingredient("mincedRedOnion", guacamolePerfectRecipe, 2, tableSpoon);
        Ingredient serranoChiles = new Ingredient("serranoChiles", guacamolePerfectRecipe,1,null);
        Ingredient cilantro = new Ingredient("cilantro", guacamolePerfectRecipe, 2, tableSpoon);
        Ingredient freshlyGratedBlackPepper = new Ingredient("freshlyGratedBlackPepper", guacamolePerfectRecipe, 1, dash);
        Ingredient tomato = new Ingredient("tomato", guacamolePerfectRecipe, 1/2, ripe);

        guacamoleIngredients.add(avocado);
        guacamoleIngredients.add(kosherSalt);
        guacamoleIngredients.add(limeJuice);
        guacamoleIngredients.add(mincedRedOnion);
        guacamoleIngredients.add(serranoChiles);
        guacamoleIngredients.add(cilantro);
        guacamoleIngredients.add(freshlyGratedBlackPepper);
        guacamoleIngredients.add(tomato);

        guacamolePerfectRecipe.setIngredients(guacamoleIngredients);
        guacamolePerfectRecipe.setDifficulty(Difficulty.HARD);
        Set<Category> categories = new HashSet<>();
        Category veganCategory = categoryRepository.findByDescription("Vegan");
        Category dipCategory = categoryRepository.findByDescription("Dip");
        Category avocadoCategory = categoryRepository.findByDescription("Avocado");
        categories.add(veganCategory);
        categories.add(dipCategory);
        categories.add(avocadoCategory);
        guacamolePerfectRecipe.setCategories(categories);
        guacamolePerfectRecipe.setDescription("Guacamole is so easy. All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity— will help to balance the richness of the avocado..\n" +
                "\n" +
                "You can get creative with homemade guacamole!");
        recipeRepository.save(guacamolePerfectRecipe);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
