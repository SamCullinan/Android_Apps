package edu.phystech.samir.secondcallback;

/**
 * Created by Samir on 16.04.2017.
 */

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class BackgroundTask extends AsyncTask<ArrayList<ChannelsModel>, Void, ArrayList<ChannelsModel>> {

    //объявляем наш колбек
    private ResponseCallback callback;

    //в конструкторе присваеваем его
    public BackgroundTask(ResponseCallback callback) {
        this.callback = callback;
    }

    //дальше выполняем запрос на сервер
    @Override
    protected ArrayList<ChannelsModel> doInBackground(ArrayList<ChannelsModel>... params) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL("http://novaforen.com/reward/channels.json");
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        //парсим и возвращаем наш ArrayList с данными в onPostExecute
        return new ChannelsParser().parseData(content.toString());
    }

    //а вот тут наш колбек возвращает нам результат в MainActivity
    @Override
    protected void onPostExecute(ArrayList<ChannelsModel> result) {
        callback.response(result);
    }
}