package repository;

import domain.GoogleJsonParser;
import domain.Location;
import domain.RequestManager;
import io.vavr.control.Try;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class GoogleLocationRepository implements LocationRepository {

    private static final String API_KEY = "AIzaSyAEQvKUVouPDENLkQlCF6AAap1Ze-6zMos";
    private static final String GOOGLE_URL = "https://maps.googleapis.com";

    private final RequestManager requestManager;
    private final GoogleJsonParser googleJsonParser;

    public GoogleLocationRepository(RequestManager requestManager, GoogleJsonParser googleJsonParser){
        this.requestManager = requestManager;
        this.googleJsonParser = googleJsonParser;
    }

    @Override
    public List<Location> getLocationPoints(Location start, Location end) {
        return Try.of(()->generateURL(start, end)).map(url -> requestManager.createAndSendAsyncRequest(url))
            .filter(response -> response.statusCode()==200)
            .map(response -> Try.of(()->googleJsonParser.getParsedOutput(response.body().toString())
            )).get().get();
    }


    public String generateURL(Location start, Location end) {
        return UriComponentsBuilder.fromHttpUrl(GOOGLE_URL).
                pathSegment("maps", "api", "directions", "json").
                queryParam("origin", start.getLocationString()).
                queryParam("destination", end.getLocationString()).
                queryParam("mode", "DRIVING").
                queryParam("key", API_KEY).
                toUriString();
    }
}
