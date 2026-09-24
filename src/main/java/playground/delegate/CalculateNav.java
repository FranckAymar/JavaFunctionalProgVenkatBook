package playground.delegate;

import java.math.BigDecimal;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;

public class CalculateNav {
    private final Function<String, BigDecimal> priceFinder;

    public CalculateNav(Function<String, BigDecimal> priceFinder) {
        this.priceFinder = priceFinder;
    }

    public BigDecimal compute(String price){
        return priceFinder.apply(price);
    }
}
