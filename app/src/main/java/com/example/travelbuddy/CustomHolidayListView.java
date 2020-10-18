package com.example.travelbuddy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomHolidayListView extends ArrayAdapter<String> {
    private String[] holidays;
    private String[] holidates;

    private Activity context;


    public CustomHolidayListView(@NonNull Activity context, String[] holidays,String[] holidates) {
        super(context, R.layout.holidays_listview_layout,holidays);

        this.context=context;
        this.holidays=holidays;
        this.holidates=holidates;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.holidays_listview_layout,null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) r.getTag();

        }
        viewHolder.tvw1.setText(holidays[position]);
        viewHolder.tvw2.setText(holidates[position]);
        return r;
    }

    class ViewHolder{
        TextView tvw1;
        TextView tvw2;
        ViewHolder(View v){
            tvw1 = v.findViewById(R.id.holiday);
            tvw2 = v.findViewById(R.id.holidate);
        }
    }
}
