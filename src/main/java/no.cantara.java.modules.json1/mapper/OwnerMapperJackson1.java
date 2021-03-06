package no.cantara.java.modules.json1.mapper;

import no.cantara.java.modules.json1.Owner;
import no.cantara.java.modules.json1.OwnerMapper;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;

import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;


public class OwnerMapperJackson1 implements OwnerMapper {
    private static final Logger log = getLogger(OwnerMapperJackson1.class);
    private final ObjectMapper objectMapper;


    public OwnerMapperJackson1() {
        objectMapper = new ObjectMapper();
    }

    public String toJson(Owner owner) {
        String json = "{}";
        try {
            json =  objectMapper.writeValueAsString(owner);
        } catch (JsonGenerationException e) {
            log.info("Failed to generate owner {} into json. Reason {}", owner, e.getMessage());
        } catch (JsonMappingException e) {
            log.info("Failed to map owner {} into json. Reason {}", owner, e.getMessage());
        } catch (IOException e) {
            log.info("Failed to write owner {} into json. Reason {}", owner, e.getMessage());
        }
        return json;
    }
}
