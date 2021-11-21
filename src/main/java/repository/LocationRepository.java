package repository;

import domain.Location;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LocationRepository {
    List<Location> getLocationPoints(Location start, Location end);
}

