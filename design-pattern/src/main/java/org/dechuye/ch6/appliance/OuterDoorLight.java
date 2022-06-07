package org.dechuye.ch6.appliance;

/**
 * @author dechuye
 */
public class OuterDoorLight {

    public void on() {
        System.out.println(this.getClass().getName() + "-on");
    }

    public void off() {
        System.out.println(this.getClass().getName() + "-off");
    }
}
