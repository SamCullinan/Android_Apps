package edu.phystech.samir.firstcallback;

/**
 * Created by Samir on 16.04.2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.nio.channels.Channels;
import java.util.ArrayList;

public class ChannelsAdapter extends ArrayAdapter<ChannelsModel>   {
    private Context context;
    //наш список который мы будем получать из mainactivity
    private ArrayList<ChannelsModel> model;

    //конструктор, ну а куда же без него отдаем адаптеру контекст и спарсенные данные
    public ChannelsAdapter(Context context, ArrayList<ChannelsModel> values) {
        super(context, android.R.layout.simple_list_item_1, values);
        this.context = context;
        this.model = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        //отображаем
        final TextView textView = (TextView) rowView.findViewById(android.R.id.text1);
        textView.setText(model.get(position).getName());
        return rowView;
    }
}
