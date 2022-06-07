package org.dp.ch3.absfactorypattern.store;

import org.dp.ch3.absfactorypattern.factory.ChicagoPizzaIngredientFactory;
import org.dp.ch3.absfactorypattern.pizza.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dechuye
 */
@Component("afChicagoStylePizzaStore")
public class ChicagoStylePizzaStore extends PizzaStore {

    @Autowired
    private ChicagoPizzaIngredientFactory chicagoPizzaIngredientFactory;

    @Override
    public Pizza createPizza(String type) {

        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new CheesePizza(chicagoPizzaIngredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
        }
        else if ("veggie".equals(type)) {
            pizza = new VeggiePizza(chicagoPizzaIngredientFactory);
            pizza.setName("Chicago Style Veggie Pizza");
        }
        else if ("clam".equals(type)) {
            pizza = new ClamPizza(chicagoPizzaIngredientFactory);
            pizza.setName("Chicago Style Clam Pizza");
        }
        else if ("pepperoni".equals(type)) {
            pizza = new PepperoniPizza(chicagoPizzaIngredientFactory);
            pizza.setName("Chicago Style Pepperoni Pizza");
        }
        else if ("greek".equals(type)) {
            pizza = new GreekPizza(chicagoPizzaIngredientFactory);
            pizza.setName("Chicago Style Greek Pizza");
        }
        return pizza;
    }
}
