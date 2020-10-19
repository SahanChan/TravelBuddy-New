package com.example.travelbuddy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewHolidays extends AppCompatActivity {


    private RecyclerView mHolidayList;
    FirebaseFirestore db;
    private List<Holidays> holidaysList;
    private HolidaysListAdapter holidaysListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_holidays);

        holidaysList= new ArrayList<>();

        holidaysListAdapter = new HolidaysListAdapter(holidaysList);

        mHolidayList = (RecyclerView) findViewById(R.id.recyclerView);
        mHolidayList.setHasFixedSize(true);
        mHolidayList.setLayoutManager(new LinearLayoutManager(this));
        mHolidayList.setAdapter(holidaysListAdapter);

        db = FirebaseFirestore.getInstance();

        db.collection("My Holidays").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error!=null){
                    Toast.makeText(ViewHolidays.this, "Error from database", Toast.LENGTH_SHORT).show();
                }

                for(DocumentChange doc : value.getDocumentChanges()){

                    if(doc.getType()==DocumentChange.Type.ADDED){
                        String numOfDays=doc.getDocument().getString("noOfDaysForTrip");
                        String numOfPlaces = doc.getDocument().getString("noOfPlacesToVisit");
                        String otherNotes = doc.getDocument().getString("otherNotes");

                        Holidays holidays = doc.getDocument().toObject(Holidays.class);
                        holidaysList.add(holidays);

                        holidaysListAdapter.notifyDataSetChanged();
                    }



                }

            }
        });
    }
}