package com.example.snippet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

import static io.vavr.API.*;
import static io.vavr.API.run;

/**
 * @author DechuYe
 */
public class Dd {
    public static void main(String[] a) throws IOException {
        String arg = new Scanner(System.in).nextLine();
        Match(arg).of(
                Case($(isIn("-h", "--help")), o -> run(Dd::displayHelp)),
                Case($(isIn("-v", "--version", "--ver")), o -> run(Dd::displayVersion)),
                Case($(), o -> run(() -> {
                    throw new IllegalArgumentException(arg);
                }))
        );
    }

    public static void displayHelp() {
         System.out.println( "about help info");
    }

    public static void displayVersion() {
        System.out.println( "about version info");
    }

    public static Predicate<String> isIn(String... args) {
        return (x) -> Arrays.asList(args).contains(x);
    }
}
