package org.jetbrains;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;


public class App {
    public static void main(String[] args) throws IOException {


        // Java

        List<Person> people = List.of(
                new Person("Anton", 16),
                new Person("Anton", 21),
                new Person("Anton", 21),
                new Person("Anton", 22),
                new Person("Anton", 22),
                new Person("Hello", 25)
        );

        Map<Integer, List<Person>> groupedByName = people.stream()
                .collect(groupingBy(Person::getAge));






        System.out.println(groupedByName);

    }
}
