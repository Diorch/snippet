package org.dechuye.ch3;

import com.example.ioutility.Reader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Console;

/**
 * @author dechuye
 */

public class App {

    SimplePizzaFactory simplePizzaFactory;
    ClassPathXmlApplicationContext applicationContext;

    public SimplePizzaFactory getSimplePizzaFactory() {
        return simplePizzaFactory;
    }

    public void setSimplePizzaFactory(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public ClassPathXmlApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ClassPathXmlApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public App init() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-ctx.xml");
        simplePizzaFactory = applicationContext.getBean("simplePizzaFactory", SimplePizzaFactory.class);
        return this;
    }

    public static void main(String[] args) {
        final App app = new App().init();

        System.out.println("Please input pizza type: ");
        final String type = Reader.str();
        final Pizza cheese = app.orderPizza(type);
        System.out.println(cheese);

    }

    Pizza orderPizza(String type) {
        final Pizza pizza = simplePizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
