package com.example.ioutility;

import sun.net.util.URLUtil;

import java.io.*;
import java.net.URL;

/**
 * @author DechuYe
 */
public class ResourceTest {

    public static void main(String[] args) {


        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("CLASSPATH"));
//        testResource();

    }

    public static void testResource2() {
        final URLUtil urlUtil = new URLUtil();
//        try( InputStream resourceAsStream = URLUtil.class.getResourceAsStream("/javax/el/PrivateMessages.properties")) {
        try( InputStream resourceAsStream = ResourceTest.class.getResourceAsStream("/javax/el/PrivateMessages.properties")) {
            if (resourceAsStream == null) {
                System.out.println("not found");
                return;
            }
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            bufferedReader.lines().forEach(System.out::println);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void testResource() {
        final InputStream resourceAsStream = ResourceTest.class.getResourceAsStream("/log4j2.xml");
        final URL resource = ResourceTest.class.getClassLoader().getResource("log4j2.xml");
        try (final InputStream inputStream = ResourceTest.class.getClassLoader().getResourceAsStream("log4j2.xml")) {
            if (inputStream == null) {
                System.out.println("not found");
                return;
            }
            final StudentDTO studentDTO = (StudentDTO) ResourceTest.class.getClassLoader().loadClass("com.example.ioutility.StudentDTO").newInstance();
            System.out.println(studentDTO.getAge());
//            final Scanner scanner = new Scanner(inputStream);
//            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
//            }
            final BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException exception) {
            exception.printStackTrace();
        }
    }
}
