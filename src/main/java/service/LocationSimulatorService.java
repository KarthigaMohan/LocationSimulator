package service;

import domain.EqualIntervalCalculator;
import domain.Location;
import org.springframework.stereotype.Service;
import repository.LocationRepository;

import java.util.List;

@Service
public class LocationSimulatorService {

    private final LocationRepository locationRepository;
    private final EqualIntervalCalculator equalIntervalCalculator;

    public LocationSimulatorService(LocationRepository locationRepository, EqualIntervalCalculator equalIntervalCalculator){
        this.locationRepository = locationRepository;
        this.equalIntervalCalculator = equalIntervalCalculator;
    }

    public List<Location> getLocationsBetweenTwoPoints(Location start, Location end){
        List<Location> listFromRepository = locationRepository.getLocationPoints(start, end);
        listFromRepository.add(0,start);
        return equalIntervalCalculator.getLocationsWithEqualIntervals(listFromRepository);
    }

}
