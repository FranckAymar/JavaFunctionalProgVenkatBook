package playground.exception.imperative;

import java.util.List;

/**
 * Can decide to throw an exception if error or continue. Easy to handle
 */
public class Client {

	static void main() {
		var iataCodes = List.of("AUS", "DFW", "HOU", "IHA", "SAT");

		for (var result : AirportNames.getName(iataCodes)) {
			if (result.isDataPresent()) {
				System.out.println(result.getDataOrThrow());
			} else {
				System.out.println("Error: " +
						result.getExceptionOrThrow().getMessage());
			}
		}
	}
}
