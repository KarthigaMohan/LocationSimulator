package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EqualIntervalCalculatorTest {

    private EqualIntervalCalculator equalIntervalCalculator;

    @BeforeEach
    public void setup(){
        equalIntervalCalculator = new EqualIntervalCalculator();
    }

    @Test
    public void testNumberOfLocationPoints(){
        List<Location> locations = List.of(
                new Location(12.9316597,77.6285175),
                new Location(12.9300056 ,77.6292527)
        );
        List<Location> ans = equalIntervalCalculator.getLocationsWithEqualIntervals(locations);
        assertTrue(ans.size()==4);
    }

}
