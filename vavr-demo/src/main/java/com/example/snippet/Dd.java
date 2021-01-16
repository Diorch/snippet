package com.example.snippet;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

import static io.vavr.API.*;

/**
 * @author DechuYe
 */
public class Dd {
    public static void main(String[] a) {
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
        return x -> Optional.ofNullable(args).map(valid -> Arrays.asList(valid).contains(x)).orElse(false);
    }
}
