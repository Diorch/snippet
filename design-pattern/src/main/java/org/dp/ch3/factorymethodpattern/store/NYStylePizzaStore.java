package org.dp.ch3.factorymethodpattern.store;

import org.dp.ch3.factorymethodpattern.pizza.*;
import org.springframework.stereotype.Component;

/**
 * @author dechuye
 */
@Component("fmNYStylePizzaStore")
public class NYStylePizzaStore extends PizzaStore {


    @Override
    public Pizza createPizza(String type) {

        if (CHEESE.equals(type)) {
            return new NYStyleCheesePizza();
        }
        else if (VEGGIE.equals(type)) {
            return new NYStyleVeggiePizza();
        }
        else if (CLAM.equals(type)) {
            return new NYStyleClamPizza();
        }
        else if (PEPPERONI.equals(type)) {
            return new NYStylePepperoniPizza();
        }
        else {
            return null;
        }
    }

    public static final String CHEESE = "cheese";
    public static final String VEGGIE = "veggie";
    public static final String CLAM = "clam";
    public static final String PEPPERONI = "pepperoni";
}
