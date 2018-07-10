package io.github.saltytt.grouptracker.settings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import io.github.saltytt.grouptracker.Main;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Settings {

    private static String token = "";
    public static String prefix = "";

    public static String getBotToken() { return Settings.token; }

    public static void load() {

        final JSONParser jsonParser = new JSONParser();
        Object object;

        try {

            object = jsonParser.parse(new FileReader(new File(Main.FILE_PATH + "/settings.json")));
            final JSONObject mainBlock = (JSONObject) object;

            token = (String) mainBlock.get("token");

            if (token.equals("")) {
                System.out.println("No bot token configured, shutting down");
                System.exit(0);
            }

            prefix = (String) mainBlock.get("prefix");

            if (prefix.equals("")) {
                System.out.println("No bot prefix configured, shutting down");
                System.exit(0);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}