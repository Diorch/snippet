package org.dechuye.ch3.factorymethodpattern.pizza;

import java.util.Arrays;

/**
 * @author dechuye
 */
public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }

    @Override
    public void prepare() {

    }

}
