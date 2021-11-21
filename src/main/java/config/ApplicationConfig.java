package config;

import controller.LocationSimulatorController;
import domain.EqualIntervalCalculator;
import domain.GoogleJsonParser;
import domain.RequestManager;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import repository.GoogleLocationRepository;
import repository.LocationRepository;
import service.LocationSimulatorService;

@SpringBootConfiguration
public class ApplicationConfig {
    @Bean
    public GoogleJsonParser googleJsonParser(){
        return new GoogleJsonParser();
    }

    @Bean
    public RequestManager requestManager(){
        return new RequestManager();
    }

    @Bean
    public EqualIntervalCalculator equalIntervalCalculator(){
        return new EqualIntervalCalculator();
    }

    @Bean
    public LocationRepository locationRepository(){
        return new GoogleLocationRepository(requestManager(), googleJsonParser());
    }

    @Bean
    public LocationSimulatorService service(){
        return new LocationSimulatorService(locationRepository(), equalIntervalCalculator());
    }

    @Bean
    public LocationSimulatorController locationSimulatorController(){
        return new LocationSimulatorController(service());
    }


}
