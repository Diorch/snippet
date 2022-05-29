package org.dechuye.ch3.absfactorypattern.store;

import org.dechuye.ch3.absfactorypattern.pizza.Pizza;

/**
 * @author dechuye
 */
public abstract class PizzaStore {


    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);
        if (pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
        return pizza;
    }

    public abstract Pizza createPizza(String type);
}
