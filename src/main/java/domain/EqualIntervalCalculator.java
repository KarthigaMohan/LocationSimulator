package domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

@Component
public class EqualIntervalCalculator {

    private static double DISTANCE = 0.0005;

    public List<Location> getLocationsWithEqualIntervals(List<Location> initialLocations) {
        List<Location> locations = new ArrayList<>();
        for (int endPoint =1; endPoint< initialLocations.size(); endPoint++ ){
            locations.addAll(getLocationsBetweenTwoPoints(initialLocations.get(endPoint-1), initialLocations.get(endPoint)));
        }
        locations.add(initialLocations.get(initialLocations.size()-1));
        return locations;
    }

    private List<Location> getLocationsBetweenTwoPoints(Location start, Location end){
        List<Location> locationsBetweenTwoPoints = new ArrayList<>();
        double angleInRadians = getAngle(start, end);
        while (checkIfEligible(start, end)){
            locationsBetweenTwoPoints.add(start);
            start = getNextLocation(start, angleInRadians);
        }
        return locationsBetweenTwoPoints;
    }

    private Location getNextLocation(Location start, double angleInRadians){
        return new Location(start.latitude() + DISTANCE * cos(angleInRadians),
                start.longitude() + DISTANCE * sin(angleInRadians));
    }

    private double getAngle(Location start, Location end) {
        return atan2(end.longitude() - start.longitude(), end.latitude() - start.latitude());
    }

    private boolean checkIfEligible(Location start, Location end) {
        double distance = Math.sqrt((end.latitude() - start.latitude()) * (end.latitude() - start.latitude()) +
                ((end.longitude() - start.longitude()) * (end.longitude() - start.longitude())));
        return ( distance > DISTANCE);
    }

}
