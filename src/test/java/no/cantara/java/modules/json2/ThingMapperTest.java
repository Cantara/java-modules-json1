package no.cantara.java.modules.json2;

import no.cantara.java.modules.json1.Owner;
import no.cantara.java.modules.json1.mapper.OwnerMapperJackson1;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.slf4j.LoggerFactory.getLogger;

public class ThingMapperTest {
    private static final Logger log = getLogger(ThingMapperTest.class);

    private OwnerMapperJackson1 ownerMapper;
    private static final String expectedJson = "{\"id\":\"ownerId\",\"name\":\"owns test me\"}";

    @BeforeMethod
    public void setUp() throws Exception {
        ownerMapper = new OwnerMapperJackson1();
    }

    @Test
    public void testToJson() throws Exception {
        Owner thing = new Owner("ownerId", "owns test me");
        String json = ownerMapper.toJson(thing);
        log.trace("Json from Owner: {}", json);
        JSONAssert.assertEquals(expectedJson, json,true);

    }
}