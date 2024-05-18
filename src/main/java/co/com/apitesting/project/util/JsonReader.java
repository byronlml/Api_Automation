package co.com.apitesting.project.util;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class JsonReader {

    private JsonReader(){}
    public static JSONObject getJsonData(String data) throws IOException, ParseException {
        // pass the path of the testData.json file
        File filename = new File(data);
        // convert json file into string
        String json = FileUtils.readFileToString(filename, UTF_8);
        // parse the string into object
        Object obj = new JSONParser().parse(json);

        return (JSONObject) obj;
    }
    public static String getTestData(String data) throws IOException, ParseException {
        return   getJsonData(data).toJSONString();
    }
}
