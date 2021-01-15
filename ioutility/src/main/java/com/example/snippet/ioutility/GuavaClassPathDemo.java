package com.example.snippet.ioutility;

import com.google.common.reflect.ClassPath;

import java.io.IOException;

/**
 * @author DechuYe
 */
public class GuavaClassPathDemo {

    public static void main(String[] args) throws IOException {
        final ClassPath classPath = ClassPath.from(Thread.currentThread().getContextClassLoader());
        for (ClassPath.ClassInfo e : classPath.getTopLevelClasses("javax.el")) {
            System.out.println(e.getName());
        }
    }
}
