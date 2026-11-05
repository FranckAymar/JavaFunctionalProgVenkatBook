package playground.exception.functional;

import java.util.List;

public class Client {

    static void main() {

        var iataCodes = List.of("AUS", "DFW", "HOU", "IHA", "SAT");

        AirportNames.getName(iataCodes)
                .stream()
                .map(result -> switch (result) {
                     case Success(String name) -> name;
                     case Failure(Throwable throwable) -> "Error: " + throwable.getMessage();
                 }).forEach(
                        System.out::println
                );
    
    }
}
