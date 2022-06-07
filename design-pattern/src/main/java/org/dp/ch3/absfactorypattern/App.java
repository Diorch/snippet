package org.dp.ch3.absfactorypattern;

import com.ioutility.Reader;
import org.dp.ch3.absfactorypattern.pizza.Pizza;
import org.dp.ch3.absfactorypattern.store.PizzaStore;
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
        stores.put("NY", (PizzaStore) applicationContext.getBean("afNYStylePizzaStore"));
        stores.put("Chicago", (PizzaStore) applicationContext.getBean("afChicagoStylePizzaStore"));
        return this;
    }

    public static void main(String[] args) {
        final App app = new App().init();
        while (true) {
            System.out.println("Please choose pizza store: NY/Chicago");
            final String s = Reader.str();
            if ("bye".equals(s)) {
                break;
            }
            PizzaStore store = app.stores.get(s);
            if (store == null) {
                System.out.println("The store doesn't exist");
                continue;
            }

            System.out.println("Please input pizza type: ");
            final String type = Reader.str();
            if ("bye".equals(type)) {
                break;
            }
            final Pizza pizza = store.orderPizza(type);
            if (pizza == null) {
                System.out.println("The pizza doesn't exist");
                continue;
            }
            System.out.println("************ Pizza Completed ************ ");
            System.out.println(pizza);
            System.out.println("=========================================> next");
        }
    }

}
