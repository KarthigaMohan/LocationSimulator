package repository;

import domain.GoogleJsonParser;
import domain.Location;
import domain.RequestManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleLocationRepositoryTest {

    private RequestManager requestManager = new RequestManager();
    private GoogleJsonParser gjp = new GoogleJsonParser();
    private GoogleLocationRepository googleLocationRepository = new GoogleLocationRepository(requestManager, gjp);
    Location start = new Location (12.93175,77.62872);
    Location end = new Location(12.92662, 77.63696 );

    @Test
    void testCorrectUrlGeneration(){
        assertEquals(googleLocationRepository.generateURL(start, end),
"https://maps.googleapis.com/maps/api/directions/json?origin=12.93175,77.62872&destination=12.92662,77.63696&mode=DRIVING&key=AIzaSyAEQvKUVouPDENLkQlCF6AAap1Ze-6zMos");
    }
}
