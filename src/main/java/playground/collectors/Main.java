package playground.collectors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Main {

    record Person(String name, int age) {
    }

    static void main() {

        List<Person> persons = List.of(new Person("name", 20));

        persons.stream()
                .filter(person -> person.age > 20)
                .collect(
                        ArrayList::new,
                        ArrayList::add,
                        ArrayList::add
                ); //Verbose

        persons.stream()
                .filter(person -> person.age > 20)
                .collect(
                        Collectors.toList()
                );

        // Group the names by age
        Map<Integer, List<String>> collect = persons
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Person::age,
                                Collectors.mapping(
                                        Person::name,
                                        Collectors.toList())
                        )
                );

        // group the names by their first character and then get the oldest person in each group.
        persons.stream()
                .collect(
                        Collectors.groupingBy(
                                person -> person.name.charAt(0),
                                Collectors.reducing(
                                        BinaryOperator.maxBy(
                                                Comparator.comparing(Person::age)
                                        )
                                )
                        )
                );



    }
}
