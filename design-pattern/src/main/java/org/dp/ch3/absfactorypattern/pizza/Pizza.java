package org.dp.ch3.absfactorypattern.pizza;

import org.dp.ch3.absfactorypattern.ingredient.*;

import java.util.Arrays;

/**
 * @author dechuye
 */
public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;

    public abstract void prepare();

    public void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut(){
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" + "name='" + name + '\'' + ", dough=" + dough + ", sauce=" + sauce + ", veggies="
                + Arrays.toString(veggies) + ", cheese=" + cheese + ", pepperoni=" + pepperoni + ", clam=" + clam + '}';
    }
}
