package edu.phystech.samir.secondcallback;

/*
*  //обявляем интерфейс
    private OnScoreSavedListener onScoreSavedListener;

    //создаем интерфейс с колбеком
    public interface OnScoreSavedListener {
        public void onScoreSaved();
    }

    //создаем сеттер для листенера
    public void setOnScoreSavedListener(OnScoreSavedListener listener) {
        onScoreSavedListener = listener;
    }

    //где то вызывается его метод для срабатывания
    onScoreSavedListener.onScoreSaved();

    //а дальше вызываем в активити
MyCustomView slider = (MyCustomView) view.findViewById(R.id.slider)
    slider.setOnScoreSavedListener(new OnScoreSavedListener() {
        @Override
        public void onScoreSaved() {
            Log.v("","EVENT FIRED");
        }
});

*
*
*
* */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements ResponseCallback {

    private ListView listView;
    private ChannelsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        new BackgroundTask(this).execute();
    }

    @Override
    public void response(ArrayList<ChannelsModel> response) {
        adapter = new ChannelsAdapter(this, response).setOnClickListener(new ChannelsAdapter.OnAdapterClickListener() {
            @Override
            public void onCLick(String name) {
                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
                //здесь можно вызывать другу активити или запускать другой фрагмент
            }
        });
        listView.setAdapter(adapter);
    }
}
