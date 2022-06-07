package com.ioutility;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author dechuye
 */
public class Reader {

    public static List<String> strs() {
        final Scanner scanner = new Scanner(System.in);
        return Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
    }

    public static List<Long> longs() {
        final Scanner scanner = new Scanner(System.in);
        return Arrays.stream(scanner.nextLine().split(" ")).map(Long::new).collect(Collectors.toList());
    }

    public static List<Integer> ints() {
        final Scanner scanner = new Scanner(System.in);
        return Arrays.stream(scanner.nextLine().split(" ")).map(Integer::new).collect(Collectors.toList());
    }

    public static String str() {
        return new Scanner(System.in).next();
    }
}
