package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.*;

public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Car> cars = MockData.getCars();
        List<Car> carsLessThan20kAndYellow = cars.stream()
                .filter(car -> car.getPrice() < 20_000.00)
                .filter(car -> car.getColor().equals("Yellow"))
                .collect(Collectors.toList());
        carsLessThan20kAndYellow.forEach(System.out::println);
    }

    @Test
    public void dropWhile() throws Exception {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("using dropWhile");
        Stream.of(2, 4, 6, 8, 9, 10, 12).dropWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
    }

    @Test
    public void takeWhile() throws Exception {
        // using filter
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("using take while");
        Stream.of(2, 4, 6, 8, 9, 10, 12).takeWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
    }

    @Test
    public void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = stream(numbers).filter(n -> n == 50).findFirst().orElse(-1);
        System.out.println(result);
    }

    @Test
    public void findAny() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        int result = stream(numbers).filter(n -> n == 9).findAny().orElse(-1);
        System.out.println(result);
    }

    @Test
    public void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};
        boolean allMatch = stream(even).allMatch(n -> n % 2 == 0);

        assertTrue(allMatch);
        System.out.println(allMatch);
    }

    @Test
    public void anyMatch() throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
        boolean anyMatch = stream(evenAndOneOdd).anyMatch(n -> n % 2 != 0);

        assertTrue(anyMatch);
        System.out.println(anyMatch);
    }

}



