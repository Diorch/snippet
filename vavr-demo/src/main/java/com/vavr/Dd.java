package com.vavr;

import java.util.*;
import java.util.function.Predicate;

import static io.vavr.API.*;

/**
 * @author DechuYe
 */
public class Dd implements Comparable<Dd> {

    int i;

    public static void main(String[] a) {
        String arg = new Scanner(System.in).nextLine();
        Match(arg).of(
                Case($(isIn("-h", "--help")), o -> run(Dd::displayHelp)),
                Case($(isIn("-v", "--version", "--ver")), o -> run(Dd::displayVersion)),
                Case($(), o -> run(() -> {
                    throw new IllegalArgumentException(arg);
                }))
        );

        List<? super Integer> l = new ArrayList<>();
        final Object object = l.get(0);
        l.add(2);

        List<? extends Integer> ll = new ArrayList<>();
//        ll.add(2);
        final Integer integer = ll.get(0);
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

    static <T extends Comparable<T>> T max(Collection<T> coll) {
        Iterator<T> i = coll.iterator();
        T candidate = i.next();

        while (i.hasNext()) {
            T next = i.next();
            if (next.compareTo(candidate) > 0)
                candidate = next;
        }
        return candidate;
    }

    @Override
    public int compareTo(Dd o) {
        return Integer.compare(this.i, o.i);
    }
}
