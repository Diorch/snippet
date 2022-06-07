package com.snippet;

import io.vavr.Lazy;
import io.vavr.Tuple;
import io.vavr.*;
import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Option;
import io.vavr.control.Try;
import io.vavr.control.Validation;
import io.vavr.test.Arbitrary;
import io.vavr.test.Property;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

import static io.vavr.API.*;
import static io.vavr.Predicates.isIn;
import static org.junit.Assert.*;

/**
 * @author DechuYe
 */
@Slf4j
public class VavrTest {

    @Test
    public void givenValue_whenNullCheckNeeded_thenCorrect() {
        Object possibleNullObj = null;
        if (possibleNullObj == null) {
            possibleNullObj = "someDefaultValue";
        }
        assertNotNull(possibleNullObj);
    }

    @Test(expected = NullPointerException.class)
    public void givenValue_whenNullCheckNeeded_thenCorrect2() {
        Object possibleNullObj = null;
        assertEquals("somevalue", possibleNullObj.toString());
    }

    @Test
    public void givenValue_whenCreatesOption_thenCorrect() {
        Option<Object> noneOption = Option.of(null);
        Option<Object> someOption = Option.of("val");

        assertEquals("None", noneOption.toString());
        assertEquals("Some(val)", someOption.toString());
    }

    @Test
    public void givenNull_whenCreatesOption_thenCorrect() {
        String name = null;
        Option<String> nameOption = Option.of(name);

        assertEquals("baeldung", nameOption.getOrElse("baeldung"));
    }

    @Test
    public void givenNonNull_whenCreatesOption_thenCorrect() {
        String name = "baeldung";
        Option<String> nameOption = Option.of(name);

        assertEquals("baeldung", nameOption.getOrElse("notbaeldung"));
    }

    @Test
    public void whenCreatesTuple_thenCorrect1() {
        Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
        String element1 = java8._1();
        int element2 = java8._2;

        assertEquals("Java", element1);
        assertEquals(8, element2);
    }

    @Test
    public void whenCreatesTuple_thenCorrect2() {
        Tuple3<String, Integer, Double> java8 = Tuple.of("Java", 8, 1.8);
        String element1 = java8._1;
        int element2 = java8._2();
        double element3 = java8._3();

        assertEquals("Java", element1);
        assertEquals(8, element2);
        assertEquals(1.8, element3, 0.1);
    }

    @Test(expected = ArithmeticException.class)
    public void givenBadCode_whenThrowsException_thenCorrect() {
        int i = 1 / 0;
    }

    @Test
    public void givenBadCode_whenTryHandles_thenCorrect() {
        Try<Integer> result = Try.of(() -> 1 / 0);

        assertTrue(result.isFailure());
    }

    @Test
    public void givenBadCode_whenTryHandles_thenCorrect2() {
        Try<Integer> computation = Try.of(() -> 1 / 0);
        int errorSentinel = computation.getOrElse(-1);

        assertEquals(-1, errorSentinel);
    }

    @Test(expected = MyException.class)
    public void givenBadCode_whenTryHandles_thenCorrect3() {
        Try<Integer> result = Try.of(() -> 1 / 0);
        result.getOrElseThrow(MyException::new);
    }

    static class MyException extends RuntimeException {
        public MyException() {
            super();
        }

//        public MyException(String s) {
//            super(s);
//        }
    }

    @Test
    public void givenJava8Function_whenWorks_thenCorrect() {
        Function<Integer, Integer> square = (num) -> num * num;
        int result = square.apply(2);

        assertEquals(4, result);
    }

    @Test
    public void givenJava8BiFunction_whenWorks_thenCorrect() {
        BiFunction<Integer, Integer, String> sum = (num1, num2) -> num1 + num2 + "";
        String result = sum.apply(5, 7);

        assertEquals("12", result);
    }

    @Test
    public void givenVavrFunction_whenWorks_thenCorrect() {
        Function1<Integer, Integer> square = (num) -> num * num;
        int result = square.apply(2);

        assertEquals(4, result);
    }

    @Test
    public void givenVavrBiFunction_whenWorks_thenCorrect() {
        Function2<Integer, Integer, Integer> sum = (num1, num2) -> num1 + num2;
        int result = sum.apply(5, 7);

        assertEquals(12, result);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenImmutableCollectionThrows_thenCorrect() {
        java.util.List<String> wordList = Arrays.asList("abracadabra");
        java.util.List<String> list = Collections.unmodifiableList(wordList);
        list.add("boom");
    }

    @Test
    public void whenCreatesVavrList_thenCorrect() {
        List<Integer> intList = List.of(1, 2, 3);

        assertEquals(3, intList.length());
        assertEquals(new Integer(1), intList.get(0));
        assertEquals(new Integer(2), intList.get(1));
        assertEquals(new Integer(3), intList.get(2));
    }

    @Test
    public void whenSumsVavrList_thenCorrect() {
        int sum = List.of(1, 2, 3).sum().intValue();

        assertEquals(6, sum);
    }

    public static class Person {
        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person [" +
                    "name=" + name +
                    ", age=" + age +
                    ']';
        }

        // standard constructors, setters and getters, toString
    }

    static class PersonValidator {
        String NAME_ERR = "Invalid characters in name: ";
        String AGE_ERR = "Age must be at least 0";

        public Validation<Seq<String>, Person> validatePerson(String name, int age) {
            return Validation.combine(validateName(name), validateAge(age)).ap(Person::new);
        }

        private Validation<String, String> validateName(String name) {
            String invalidChars = name.replaceAll("[a-zA-Z ]", "");
            return invalidChars.isEmpty() ? Validation.valid(name) : Validation.invalid(NAME_ERR + invalidChars);
        }

        private Validation<String, Integer> validateAge(int age) {
            return age < 0 ? Validation.invalid(AGE_ERR) : Validation.valid(age);
        }
    }

    @Test
    public void whenValidationWorks_thenCorrect() {
        PersonValidator personValidator = new PersonValidator();

//        Validation<List<String>, Person>
        final Validation<Seq<String>, Person> valid = personValidator.validatePerson("John Doe", 30);

//        Validation<List<String>, Person>
        final Validation<Seq<String>, Person> invalid = personValidator.validatePerson("John? Doe!4", -1);

        assertEquals("Valid(Person [name=John Doe, age=30])", valid.toString());

        assertEquals("Invalid(List(Invalid characters in name: ?!4, Age must be at least 0))", invalid.toString());
    }

    @Test
    public void givenFunction_whenEvaluatesWithLazy_thenCorrect() {
        Lazy<Double> lazy = Lazy.of(Math::random);
        assertFalse(lazy.isEvaluated());

        double val1 = lazy.get();
        assertTrue(lazy.isEvaluated());

        double val2 = lazy.get();
        assertEquals(val1, val2, 0.1);
    }

    @Test
    public void whenIfWorksAsMatcher_thenCorrect() {
        int input = 3;
        String output;
        if (input == 0) {
            output = "zero";
        }
        if (input == 1) {
            output = "one";
        }
        if (input == 2) {
            output = "two";
        }
        if (input == 3) {
            output = "three";
        } else {
            output = "unknown";
        }

        assertEquals("three", output);
    }

    @Test
    public void whenMatchworks_thenCorrect() {
        int input = 2;
        String output = Match(input).of(
                Case($(1), "one"),
                Case($(2), "two"),
                Case($(3), "three"),
                Case($(), "?"));

        assertEquals("two", output);
    }

    //    @Test
    // public static void main(String[] a) throws IOException {
    //     String arg = new Scanner(System.in).nextLine();
    //     Match(arg).of(
    //             Case($(isIn("-h", "--help")), o -> run(VavrTest::displayHelp)),
    //             Case($(isIn("-v", "--version")), o -> run(VavrTest::displayVersion)),
    //             Case($(), o -> run(() -> {
    //                 throw new IllegalArgumentException(arg);
    //             }))
    //     );
    // }

    public static void displayHelp() {
        System.out.println("help info...");
    }

    public static void displayVersion() {
        System.out.println("version info...");
    }

    @Test
    public void testPropertyChecking() {
        Arbitrary<Integer> ints = Arbitrary.integer();

        // square(int) >= 0: OK, passed 1000 tests.
        Property.def("square(int) >= 0")
                .forAll(ints)
                .suchThat(i -> i * i >= 0)
                .check()
                .assertIsSatisfied();
    }
}
