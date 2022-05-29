package org.dechuye.ch3.factorymethodpattern;

import com.example.ioutility.Reader;
import org.dechuye.ch3.factorymethodpattern.pizza.Pizza;
import org.dechuye.ch3.factorymethodpattern.store.PizzaStore;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dechuye
 */

public class App {

    ClassPathXmlApplicationContext applicationContext;
    Map<String, PizzaStore> stores = new HashMap<>();

    public App init() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-ctx.xml");

        stores.put("NY", (PizzaStore) applicationContext.getBean("fmNYStylePizzaStore"));
        stores.put("Chicago", (PizzaStore) applicationContext.getBean("fmChicagoStylePizzaStore"));
        return this;
    }

    public static void main(String[] args) {
        final App app = new App().init();
        System.out.println("Please choose pizza store: NY/Chicago");
        PizzaStore store = app.stores.get(Reader.str());

        System.out.println("Please input pizza type: ");
        final String type = Reader.str();

        final Pizza pizza = store.orderPizza(type);
        System.out.println("************ Pizza Completed ************ ");
        System.out.println(pizza);
    }

}
