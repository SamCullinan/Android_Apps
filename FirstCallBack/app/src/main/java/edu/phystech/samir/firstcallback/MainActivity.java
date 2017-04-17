package edu.phystech.samir.firstcallback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;

//подключили ResponseCallback к классу, и теперь можем получать то что этот колбек принимает
public class MainActivity extends AppCompatActivity implements ResponseCallback {

    //объявляем нужные классы
    private ListView listView;
    private ChannelsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        //вызываем наш AsyncTask и передаем ему контект
        //в котором есть ResponseCallback при помощи this
        new BackgroundTask(this).execute();
    }

    // в методе колбека создаем адаптер и отображаем список
    @Override
    public void response(ArrayList<ChannelsModel> response) {
        adapter = new ChannelsAdapter(this, response);
        listView.setAdapter(adapter);
    }
}