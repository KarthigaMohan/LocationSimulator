package controller;

import domain.EqualIntervalCalculator;
import domain.GoogleJsonParser;
import domain.Location;
import domain.RequestManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.GoogleLocationRepository;
import repository.LocationRepository;
import service.LocationSimulatorService;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LocationSimulatorControllerTest {

    private LocationSimulatorController locationSimulatorController;
    private RequestManager requestManager;
    private GoogleJsonParser googleJsonParser;
    private LocationRepository repo;
    private EqualIntervalCalculator calculator;
    private LocationSimulatorService service;

    @BeforeEach
    public void setup(){
        requestManager = new RequestManager();
        googleJsonParser = new GoogleJsonParser();
        repo = new GoogleLocationRepository(requestManager, googleJsonParser);
        calculator = new EqualIntervalCalculator();
        service = new LocationSimulatorService(repo, calculator);
        locationSimulatorController = new LocationSimulatorController(service);
    }

    @Test
    void getPoints(){
        Location start = new Location(12.93175, 77.62872 );
        Location end = new Location(12.92662, 77.63696 );
        assertFalse(locationSimulatorController.getLocationPointsBetweenTwoPoints(start, end).isEmpty());
    }
}
