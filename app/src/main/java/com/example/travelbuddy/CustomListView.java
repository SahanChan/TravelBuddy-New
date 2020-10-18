package com.example.travelbuddy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListView extends ArrayAdapter<String> {
    private String[] sitesNames;

    private String[] sitesDesc;
    private Integer[] imgId;
    private Activity context;
    public CustomListView(@NonNull Activity context, String[] sitesNames,String[] sitesDesc, Integer[] imgId) {
        super(context, R.layout.listview_layout,sitesNames);

        this.context=context;
        this.sitesNames = sitesNames;
        this.sitesDesc = sitesDesc;
        this.imgId = imgId;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) r.getTag();

        }

        viewHolder.ivw.setImageResource(imgId[position]);
        viewHolder.tvw1.setText(sitesNames[position]);
        viewHolder.tvw2.setText(sitesDesc[position]);
        return r;
    }

    class ViewHolder{
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;
        ViewHolder(View v){
            tvw1 = v.findViewById(R.id.siteName);
            tvw2 = v.findViewById(R.id.siteDesc);
            ivw = v.findViewById(R.id.imageView);

        }
    }
}
