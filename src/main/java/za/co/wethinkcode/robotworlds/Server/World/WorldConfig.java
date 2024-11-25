package za.co.wethinkcode.robotworlds.Server.World;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONException;
import org.json.JSONObject;

public class WorldConfig {

    public static JSONObject extractDataFromConfigFile() {
        return processJSON();
    }

    private static JSONObject processJSON() {
        String jsonString = "";
        JSONObject data;
        try {
            jsonString = readConfigFile();
            jsonString = jsonString.replace("\n", "").replace("\r", "");
        } catch (IOException e) {
            System.out.println("Problem with config file.");
        }

        try {
            data = new JSONObject(jsonString);
            return data;
        } catch (JSONException e) {
            System.out.println("Problem with format of config file.");
        }
        return null;
    }

    private static String readConfigFile() throws IOException {
        String result;
        try {
            String file = "src/main/resources/ConfigFile.json";
            result = Files.readString(Path.of(file));
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (IOException e) {
            System.out.println("Config file unreadable.");
        }
        return "";
    }
}
