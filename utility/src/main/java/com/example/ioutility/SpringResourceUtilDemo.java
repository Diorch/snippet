package com.example.ioutility;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * @author DechuYe
 */
public class SpringResourceUtilDemo {

    public static void main(String[] args) throws IOException {
        //成功
//        loadFile("classpath:log4j2.xml");
        //失败
//        loadFile("classpath:javax/el/PrivateMessages.properties");
        //失败
//        loadFile("classpath*:javax/el/PrivateMessages.properties");
        //失败
//        loadFile("/javax/el/PrivateMessages.properties");
        //失败
//        loadFile("classpath*:javax/el/PrivateMessages.properties");
        final DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        new BufferedReader(
                new InputStreamReader(
                        resourceLoader.getResource("classpath:javax/el/PrivateMessages.properties").getInputStream()))
        .lines().forEach(System.out::println);
    }

    private static void loadFile(String fileName) throws FileNotFoundException {
        if (StringUtils.isEmpty(fileName)) {
            return;
        }
        final File file = ResourceUtils.getFile(fileName);
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        bufferedReader.lines().forEach(System.out::println);
    }
    private static void loadFileStream(String fileName) throws FileNotFoundException {
        if (StringUtils.isEmpty(fileName)) {
            return;
        }
        final File file = ResourceUtils.getFile(fileName);
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        bufferedReader.lines().forEach(System.out::println);
    }
}
