package edu.phystech.samir.firstcallback;

/**
 * Created by Samir on 16.04.2017.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ChannelsParser {

    public ArrayList<ChannelsModel> parseData(String response) {
        ArrayList<ChannelsModel> model = new ArrayList<>();
        try {
            JSONObject json = new JSONObject(new String(response));
            JSONArray channels = json.getJSONArray("channels");
            for(int i = 0; i < channels.length(); i++) {
                ChannelsModel gru = new ChannelsModel();
                JSONObject data = channels.getJSONObject(i);
                String name = data.getString("name");
                gru.setName(name);
                model.add(gru);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return model;
    }
}
