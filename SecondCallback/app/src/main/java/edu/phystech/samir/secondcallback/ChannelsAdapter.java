package edu.phystech.samir.secondcallback;

/**
 * Created by Samir on 16.04.2017.
 */
 import android.content.Context;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.ArrayAdapter;
 import android.widget.TextView;

 import java.util.ArrayList;


public class ChannelsAdapter extends ArrayAdapter<ChannelsModel> {
    private Context context;
    private ArrayList<ChannelsModel> model;
    public OnAdapterClickListener listener;


    public ChannelsAdapter(Context context, ArrayList<ChannelsModel> values) {
        super(context, android.R.layout.simple_list_item_1, values);
        this.context = context;
        this.model = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        final TextView textView = (TextView) rowView.findViewById(android.R.id.text1);
        textView.setText(model.get(position).getName());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCLick(textView.getText().toString());
            }
        });
        return rowView;
    }

    //передаем имя
    public ChannelsAdapter setOnClickListener(OnAdapterClickListener onAdapterClickListener) {
        this.listener = onAdapterClickListener;
        return this;
    }

    //коллбек будет возвращать нам имя кликнутого айтема
    public interface OnAdapterClickListener {
        void onCLick(String name);
    }
}