package domain;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleJsonParser {

    public List<Location> getParsedOutput(String outputJson) throws IOException {
        List<Location> locations = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootTree =  objectMapper.readTree(outputJson);

        try{
            for (JsonNode jsonNode: rootTree.get("routes").get(0).get("legs").get(0).get("steps")){
                Location l = new Location(jsonNode.get("end_location").get("lat").asDouble(),jsonNode.get("end_location").get("lng").asDouble());
                locations.add(l);
            }
        }
        catch(RuntimeException e) {
            throw new JsonMappingException("JSON not in correct format: " + e);
        }
        return locations;
    }


}
