package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    @Test
    public void sortingSteamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> sorted = people.stream()
                .map(Person::getFirstName)
                .sorted()
                .collect(Collectors.toList());

        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> sorted = people.stream()
                .map(Person::getLastName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfObjets() throws IOException {
        List<Person> people = MockData.getPeople();

        Comparator<Person> comparing = Comparator
                .comparing(Person::getAge)
                .reversed()
                .thenComparing(Person::getFirstName);

        List<Person> sorted = people.stream().sorted(comparing).collect(Collectors.toList());

        sorted.forEach(System.out::println);
    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();
        List<Car> result = cars.stream()
                .filter(car -> car.getColor().equals("Blue"))
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(10)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

}
