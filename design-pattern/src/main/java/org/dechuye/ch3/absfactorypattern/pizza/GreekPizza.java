package org.dechuye.ch3.absfactorypattern.pizza;

import org.dechuye.ch3.absfactorypattern.factory.PizzaIngredientFactory;

/**
 * @author dechuye
 */
public class GreekPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public GreekPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);

        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClam();
    }

}
