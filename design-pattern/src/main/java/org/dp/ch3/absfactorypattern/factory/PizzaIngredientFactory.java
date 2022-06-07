package org.dp.ch3.absfactorypattern.factory;

import org.dp.ch3.absfactorypattern.ingredient.*;

/**
 * @author dechuye
 */
public interface PizzaIngredientFactory {

    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClam();
}
