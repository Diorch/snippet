package org.dechuye.ch3;

/**
 * @author dechuye
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        }
        else if ("greek".equals(type)) {
            pizza = new GreekPizza();
        }
        else if ("pepperoni".equals(type)) {
            pizza = new PepperoniPizza();
        }
        return pizza;
    }
}
