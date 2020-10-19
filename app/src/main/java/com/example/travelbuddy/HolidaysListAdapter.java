package com.example.travelbuddy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class HolidaysListAdapter extends RecyclerView.Adapter<HolidaysListAdapter.ViewHolder> {

    public List<Holidays> holidaysList;
    public HolidaysListAdapter(List<Holidays> holidaysList){
        this.holidaysList=holidaysList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holiday_list_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.days.setText(holidaysList.get(position).getDays());
        holder.places.setText(holidaysList.get(position).getPlaces());


    }

    @Override
    public int getItemCount() {
        return holidaysList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        View mView;

        public TextView days;
        public TextView places;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            mView = itemView;
                days = (TextView) mView.findViewById(R.id.days);
                places = (TextView) mView.findViewById(R.id.places);


        }
    }
}
