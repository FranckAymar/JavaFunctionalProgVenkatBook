package playground.transformingdata;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.IO.println;
import static playground.transformingdata.Person.SAMPLE_DATA;

public class Main {

    static void main() {

        double sum = SAMPLE_DATA.stream()
                .map(Person::emailAddresses)
                .mapToDouble(List::size)
                .average()
                .orElse(0);

        println(sum);

        DoubleSummaryStatistics collect = SAMPLE_DATA.stream()
                .collect(
                        Collectors.summarizingDouble(
                                person -> person.emailAddresses().size()
                        )
                );

        println(collect.toString());

        Map<Boolean, List<Person>> collect1 = SAMPLE_DATA
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                person -> person.emailAddresses().size() > 1
                        )
                );

        println("person with more than 1 email addresses" +collect1.get(true));
        println("person with less than 1 email addresses" +collect1.get(false));

        //counting people with the same name
        Map<String, Long> collect2 = SAMPLE_DATA.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::firstName,
                                Collectors.counting()
                        )
                );

        println(collect2);
    }
}
