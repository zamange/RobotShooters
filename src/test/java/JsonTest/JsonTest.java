package JsonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import JsonTest.pojo.SimpleTestCaseJsonPOJO;
import za.co.wethinkcode.robotworlds.Client.jsonUtility.Json;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    private String simpleTestCaseJsonSource = "{ \"name\": \"HAL\", \"command\": \"launch\"}";


    @Test
    void parse() throws IOException {

        JsonNode node = Json.parse(simpleTestCaseJsonSource);

        assertEquals(node.get("name").asText(), "HAL");
    }
    @Test
    void fromJson() throws IOException {
        JsonNode node = Json.parse(simpleTestCaseJsonSource);

        SimpleTestCaseJsonPOJO pojo = Json.fromJson(node, SimpleTestCaseJsonPOJO.class);

        assertEquals(pojo.getCommand(), "launch");
    }
    @Test
    void toJson(){
        SimpleTestCaseJsonPOJO pojo = new SimpleTestCaseJsonPOJO();
        pojo.setCommand("look");

        JsonNode node = Json.toJson(pojo);

        assertEquals(node.get("command").asText(), "look");

    }
    @Test
    void stringify() throws JsonProcessingException {
        SimpleTestCaseJsonPOJO pojo = new SimpleTestCaseJsonPOJO();
        pojo.setCommand("look");

        JsonNode node = Json.toJson(pojo);

        System.out.println(Json.stringify(node));
        System.out.println(Json.prettyPrint(node));

    }
}