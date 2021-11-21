package controller;

import domain.Location;
import org.springframework.stereotype.Controller;
import service.LocationSimulatorService;

import java.util.List;

@Controller
public class LocationSimulatorController {

    private final LocationSimulatorService locationSimulatorService;

    public LocationSimulatorController(LocationSimulatorService locationSimulatorService){
        this.locationSimulatorService = locationSimulatorService;
    }

    public List<Location> getLocationPointsBetweenTwoPoints(Location start, Location end){
        return locationSimulatorService.getLocationsBetweenTwoPoints(start, end);
    }

}
