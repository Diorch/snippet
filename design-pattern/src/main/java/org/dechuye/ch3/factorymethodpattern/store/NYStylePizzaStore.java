package org.dechuye.ch3.factorymethodpattern.store;

import org.dechuye.ch3.factorymethodpattern.pizza.*;
import org.springframework.stereotype.Component;

/**
 * @author dechuye
 */
@Component("fmNYStylePizzaStore")
public class NYStylePizzaStore extends PizzaStore {


    @Override
    public Pizza createPizza(String type) {

        if ("cheese".equals(type)) {
            return new NYStyleCheesePizza();
        }
        else if ("veggie".equals(type)) {
            return new NYStyleVeggiePizza();
        }
        else if ("clam".equals(type)) {
            return new NYStyleClamPizza();
        }
        else if ("pepperoni".equals(type)) {
            return new NYStylePepperoniPizza();
        }
        else {
            return null;
        }
    }
}
