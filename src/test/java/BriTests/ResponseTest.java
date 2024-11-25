package BriTests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import za.co.wethinkcode.robotworlds.Server.World.Response;
import za.co.wethinkcode.robotworlds.Server.World.Robot;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    @Test
    void createErrorResponseReturnsJSONObject() {
        String errorType1 = "unsupported argument";
        String errorType2 = "unsupported command";
        JSONObject result1 = Response.createErrorResponse(errorType1);
        assertNotNull(result1);
        JSONObject result2 = Response.createErrorResponse(errorType2);
        assertNotNull(result2);
    }

    @Test
    void createLaunchErrorResponseReturnsJSONObject() {
        String errorType1 = "No free location";
        String errorType2 = "Name already taken";
        JSONObject result1 = Response.createLaunchErrorResponse(errorType1);
        assertNotNull(result1);
        JSONObject result2 = Response.createLaunchErrorResponse(errorType2);
        assertNotNull(result2);
    }

    @Test
    void createLaunchResponseReturnsJSONObject() {
        Robot defaultRobot = new Robot();
        JSONObject result = Response.createLaunchResponse(defaultRobot);
        assertNotNull(result);
    }

    @Test
    void createStateResponseReturnsJSONObject() {
        Robot defaultRobot = new Robot();
        JSONObject result = Response.createStateResponse(defaultRobot);
        assertNotNull(result);
    }

    @Test
    void createLookResponseReturnsJSONObject() {
        Robot defaultRobot = new Robot();
        String resultValue = "OK";
        List<JSONObject> objects = new ArrayList<>();

        JSONObject result = Response.createLookResponse(defaultRobot, resultValue, objects);
        assertNotNull(result);
    }

    @Test
    void createForwardResponseReturnsJSONObject() {
        Robot defaultRobot = new Robot();
        String resultValue = "OK";
        String messageValue = "Done";

        JSONObject result = Response.createForwardResponse(defaultRobot, resultValue, messageValue);
        assertNotNull(result);
    }

    @Test
    void createBackResponseReturnsJSONObject() {
        Robot defaultRobot = new Robot();
        String resultValue = "OK";
        String messageValue = "Done";

        JSONObject result = Response.createBackResponse(defaultRobot, resultValue, messageValue);
        assertNotNull(result);
    }

    @Test
    void createLeftResponseReturnsJSONObject() {
        Robot defaultRobot = new Robot();
        String resultValue = "OK";
        String messageValue = "Done";

        JSONObject result = Response.createLeftResponse(defaultRobot, resultValue, messageValue);
        assertNotNull(result);
    }

    @Test
    void createRightResponseReturnsJSONObject() {
        Robot defaultRobot = new Robot();
        String resultValue = "OK";
        String messageValue = "Done";

        JSONObject result = Response.createRightResponse(defaultRobot, resultValue, messageValue);
        assertNotNull(result);
    }

    @Test
    void createErrorResponseContainsCorrectKeysAndValues() {
        String errorType1 = "unsupported argument";
        String errorType2 = "unsupported command";
        String expectedMessage1 = "Could not parse arguments";
        String expectedMessage2 = "Unsupported command";
        String result1 = Response.createErrorResponse(errorType1).toString();
        String result2 = Response.createErrorResponse(errorType2).toString();
        assertTrue(result1.contains(expectedMessage1));
        assertTrue(result2.contains(expectedMessage2));
    }

    @Test
    void createLaunchErrorResponseContainsCorrectKeysAndValues() {
        String errorType1 = "No free location";
        String errorType2 = "Name already taken";
        String expectedMessage1 = "No more space in this world";
        String expectedMessage2 = "Too many of you in this world";
        String result1 = Response.createLaunchErrorResponse(errorType1).toString();
        String result2 = Response.createLaunchErrorResponse(errorType2).toString();
        assertTrue(result1.contains(expectedMessage1));
        assertTrue(result2.contains(expectedMessage2));
    }

    @Test
    void createLaunchResponseContainsCorrectKeysAndValues() {
        Robot defaultRobot = new Robot();
        String result = Response.createLaunchResponse(defaultRobot).toString();
        String expectedReload = String.valueOf(defaultRobot.getReloadDelay());
        String expectedVisibility = String.valueOf(defaultRobot.getVisibility());
        String expectedRepair = String.valueOf(defaultRobot.getRepairDelay());
        String expectedShields = String.valueOf(defaultRobot.getShieldsStart());
        assertTrue(result.contains("position"));
        assertTrue(result.contains("visibility"));
        assertTrue(result.contains("reload"));
        assertTrue(result.contains("repair"));
        assertTrue(result.contains("shields"));
        assertTrue(result.contains(expectedReload));
        assertTrue(result.contains(expectedVisibility));
        assertTrue(result.contains(expectedRepair));
        assertTrue(result.contains(expectedShields));

    }

    @Test
    void createStateResponseContainsCorrectKeysAndValues() {
        Robot defaultRobot = new Robot();
        String result = Response.createStateResponse(defaultRobot).toString();
        String expectedShots = String.valueOf(defaultRobot.getShots());
        assertTrue(result.contains("position"));
        assertTrue(result.contains("direction"));
        assertTrue(result.contains("shields"));
        assertTrue(result.contains("shots"));
        assertTrue(result.contains("status"));
        assertTrue(result.contains(expectedShots));

    }

    @Test
    void createLookResponseContainsCorrectKeysAndValues() {
        Robot defaultRobot = new Robot();
        String resultValue = "OK";
        List<JSONObject> objects = new ArrayList<>();
        String expectedShots = String.valueOf(defaultRobot.getShots());

        String result = Response.createLookResponse(defaultRobot, resultValue, objects).toString();
        assertTrue(result.contains("result"));
        assertTrue(result.contains("objects"));
        assertTrue(result.contains("data"));
        assertTrue(result.contains("state"));
        assertTrue(result.contains(expectedShots));

    }

    @Test
    void createForwardResponseContainsCorrectKeysAndValues() {
        Robot defaultRobot = new Robot();
        String resultValue = "OK";
        String messageValue = "Done";

        String result = Response.createForwardResponse(defaultRobot, resultValue, messageValue).toString();
        assertTrue(result.contains("result"));
        assertTrue(result.contains(resultValue));
        assertTrue(result.contains("message"));
        assertTrue(result.contains(messageValue));
        assertTrue(result.contains("state"));
        assertTrue(result.contains("data"));
    }

    @Test
    void createBackResponseContainsCorrectKeysAndValues() {
        Robot defaultRobot = new Robot();
        String resultValue = "OK";
        String messageValue = "Done";

        String result = Response.createBackResponse(defaultRobot, resultValue, messageValue).toString();
        assertTrue(result.contains("result"));
        assertTrue(result.contains(resultValue));
        assertTrue(result.contains("message"));
        assertTrue(result.contains(messageValue));
        assertTrue(result.contains("state"));
        assertTrue(result.contains("data"));
    }

    @Test
    void createLeftResponseContainsCorrectKeysAndValues() {
        Robot defaultRobot = new Robot();
        String resultValue = "OK";
        String messageValue = "Done";

        String result = Response.createLeftResponse(defaultRobot, resultValue, messageValue).toString();
        assertTrue(result.contains("result"));
        assertTrue(result.contains(resultValue));
        assertTrue(result.contains("message"));
        assertTrue(result.contains(messageValue));
        assertTrue(result.contains("state"));
        assertTrue(result.contains("data"));
        assertTrue(result.contains("direction"));
    }

    @Test
    void createRightResponseContainsCorrectKeysAndValues() {
        Robot defaultRobot = new Robot();
        String resultValue = "OK";
        String messageValue = "Done";

        String result = Response.createLeftResponse(defaultRobot, resultValue, messageValue).toString();
        assertTrue(result.contains("result"));
        assertTrue(result.contains(resultValue));
        assertTrue(result.contains("message"));
        assertTrue(result.contains(messageValue));
        assertTrue(result.contains("state"));
        assertTrue(result.contains("data"));
        assertTrue(result.contains("direction"));
    }
}