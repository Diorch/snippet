package org.dp.ch3.factorymethodpattern.store;

import org.dp.ch3.factorymethodpattern.pizza.*;
import org.springframework.stereotype.Component;

/**
 * @author dechuye
 */
@Component("fmChicagoStylePizzaStore")
public class ChicagoStylePizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        if ("cheese".equals(type)) {
            return new ChicagoStyleCheesePizza();
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
