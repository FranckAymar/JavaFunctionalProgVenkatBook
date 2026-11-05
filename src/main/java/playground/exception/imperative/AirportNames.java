package playground.exception.imperative;

import playground.exception.AirportInfo;
import playground.exception.AirportInfoException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirportNames {

    public static List<DataOrException> getName(List<String> iataDatas){

        List<DataOrException> result = new ArrayList<>();

        for(String iata : iataDatas){
            try {
                result.add(
                        DataOrException.of(
                                AirportInfo.getNameOfAirport(iata.toUpperCase()))
                );
            } catch (IOException | AirportInfoException e) {
                result.add(DataOrException.of(e));
            }
        }

        return result;

    }
}
