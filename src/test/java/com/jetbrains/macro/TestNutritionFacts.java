package com.jetbrains.macro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNutritionFacts {
    @Test
    public void build() {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(1, 2)
                .calories(1)
                .fat(2)
                .carbohydrate(3)
                .build();

        Assertions.assertEquals(nutritionFacts.carbohydrate, 3);
    }

    @Test
    public void genericBuilder(){
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM)
                .addTopping(Pizza.Topping.PEPPER)
                .build();
        Assertions.assertEquals(nyPizza.toppings.size(), 1);
        Assertions.assertEquals(nyPizza.toppings.contains(Pizza.Topping.PEPPER), true);
    }
}