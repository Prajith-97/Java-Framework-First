package utility;


import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;

public class readDataFromJson {

    public static String readData(String key) throws IOException, ParseException {
            JSONParser jsonParse = new JSONParser(); //creating a json parser object
            //parsing content of json file
            JSONObject jsonObj = (JSONObject) jsonParse.parse(new FileReader("C:\\JavaIntellij\\Framework\\src\\test\\resources\\browserDetails.json"));
            //reading values
            return (String) jsonObj.get(key);

        }

    }

