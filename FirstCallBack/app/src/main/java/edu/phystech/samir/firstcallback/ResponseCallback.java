package edu.phystech.samir.firstcallback;

/**
 * Created by Samir on 16.04.2017.
 */

import java.util.ArrayList;

public interface ResponseCallback {
    void response(ArrayList<ChannelsModel> response);
}