package org.dechuye.ch6.appliance;

/**
 * @author dechuye
 */
public class CeilingLight {

    public void on() {
        System.out.println(this.getClass().getName() + "-on");
    }

    public void off() {
        System.out.println(this.getClass().getName() + "-off");
    }

    public void dim() {
        System.out.println(this.getClass().getName() + "-dim");
    }
}
