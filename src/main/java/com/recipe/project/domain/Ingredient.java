package com.recipe.project.domain;

import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer amount;

    public Ingredient(String name, Recipe recipe, Integer amount, UnitOfMeasure uom) {
        this.name = name;
        this.recipe = recipe;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient() {

    }

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    @ManyToOne
    private Recipe recipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasure uom) {
        this.uom = uom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
