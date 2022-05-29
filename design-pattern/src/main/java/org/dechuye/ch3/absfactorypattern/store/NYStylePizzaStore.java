package org.dechuye.ch3.absfactorypattern.store;

import org.dechuye.ch3.absfactorypattern.factory.NYPizzaIngredientFactory;
import org.dechuye.ch3.absfactorypattern.pizza.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dechuye
 */
@Component("afNYStylePizzaStore")
public class NYStylePizzaStore extends PizzaStore {

    @Autowired
    private NYPizzaIngredientFactory nyPizzaIngredientFactory;

    @Override
    public Pizza createPizza(String type) {

        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new CheesePizza(nyPizzaIngredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        }
        else if ("veggie".equals(type)) {
            pizza = new VeggiePizza(nyPizzaIngredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        }
        else if ("clam".equals(type)) {
            pizza = new ClamPizza(nyPizzaIngredientFactory);
            pizza.setName("New York Style Clam Pizza");
        }
        else if ("pepperoni".equals(type)) {
            pizza = new PepperoniPizza(nyPizzaIngredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        }
        else if ("greek".equals(type)) {
            pizza = new GreekPizza(nyPizzaIngredientFactory);
            pizza.setName("New York Style Greek Pizza");
        }
        return pizza;
    }
}
