package com.ioutility;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DechuYe
 */
public class GuavaTypeTokenDemo {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        System.out.println(((ParameterizedType)l.getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName());

    }
}
