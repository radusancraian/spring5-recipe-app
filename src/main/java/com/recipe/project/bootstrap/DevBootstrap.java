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
import java.util.Optional;
import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;


    public DevBootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, IngredientRepository ingredientRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public void initData() {


        Recipe guacamolePerfectRecipe = new Recipe();
        Set<Ingredient> guacamoleIngredients = new HashSet<>();

        Ingredient avocado = new Ingredient("avocado");
        Ingredient kosherSalt = new Ingredient("kosherSalt");
        Ingredient limeJuice = new Ingredient("limeJuice");
        Ingredient mincedRedOnion = new Ingredient("mincedRedOnion");
        Ingredient serranoChiles = new Ingredient("serranoChiles");
        Ingredient cilantro = new Ingredient("cilantro");
        Ingredient freshlyGratedBlackPepper = new Ingredient("freshlyGratedBlackPepper");
        Ingredient tomato = new Ingredient("tomato");

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



        recipeRepository.save(guacamolePerfectRecipe);

        ingredientRepository.save(avocado);

/*        ingredientRepository.save(kosherSalt);
        ingredientRepository.save(limeJuice);
        ingredientRepository.save(mincedRedOnion);
        ingredientRepository.save(serranoChiles);
        ingredientRepository.save(cilantro);
        ingredientRepository.save(freshlyGratedBlackPepper);
        ingredientRepository.save(tomato);*/


        avocado.setRecipe(guacamolePerfectRecipe);


        Optional<Category> categoryOptional =  categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is: " + categoryOptional.get().getDescription());
        System.out.println("UOM Id is: " + unitOfMeasureOptional.get().getId());

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
