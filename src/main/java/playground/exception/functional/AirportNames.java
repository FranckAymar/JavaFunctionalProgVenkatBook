package playground.exception.functional;

import playground.exception.AirportInfo;
import playground.exception.AirportInfoException;
import playground.exception.imperative.DataOrException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirportNames {

    public static List<Try<String>> getName(List<String> iataDatas) {
       return iataDatas.stream()
                .map(iata -> Try.of(() -> AirportInfo.getNameOfAirport(iata)))
                .map(name -> name.map(String::toUpperCase))
                .toList();
    }
}
