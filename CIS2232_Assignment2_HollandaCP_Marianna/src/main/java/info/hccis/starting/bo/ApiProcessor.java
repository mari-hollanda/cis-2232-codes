package info.hccis.starting.bo;

import info.hccis.util.UtilityRest;
import java.net.URLEncoder;
import org.json.*;

/**
 * Assignment 2 - API Processor
 * 
 * @author marianna hollanda
 * @since 2021-11-05
 */
public class ApiProcessor {

    public static final String URL = "https://www.boredapi.com/api/activity";

    public static String callApi() {
        
        String json = UtilityRest.getJsonFromRest(URL);
        JSONObject jsonObject = new JSONObject(json);

        String activity = jsonObject.getString("activity");
        return activity;

    }

}
