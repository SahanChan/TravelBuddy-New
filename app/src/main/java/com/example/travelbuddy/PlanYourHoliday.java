package com.example.travelbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PlanYourHoliday extends AppCompatActivity {
    EditText mNumDays,mNumPlaces,mNotes;
    Button mSaveBtn,mClearBtn,mViewHolidaysBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_your_holiday);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        mNumDays = findViewById(R.id.numDays);
        mNumPlaces =findViewById(R.id.numPlaces);
        mNotes=findViewById(R.id.notes);

        mSaveBtn=findViewById(R.id.saveButton);
        mClearBtn=findViewById(R.id.clearButton);
        mViewHolidaysBtn=findViewById(R.id.viewHolidaysBtn);



        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numOfDays = mNumDays.getText().toString().trim();
                String numOfPlaces = mNumPlaces.getText().toString().trim();
                String otherNotes = mNotes.getText().toString();



                Map<String,Object> holidayPlan = new HashMap<>();
                holidayPlan.put("noOfDaysForTrip",numOfDays);
                holidayPlan.put("noOfPlacesToVisit",numOfPlaces);
                holidayPlan.put("otherNotes",otherNotes);

                db.collection("My Holidays").add(holidayPlan).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(PlanYourHoliday.this, "Added to database", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PlanYourHoliday.this, "Error Saving to database", Toast.LENGTH_SHORT).show();
                    }
                });

                Toast.makeText(PlanYourHoliday.this, "Added to database", Toast.LENGTH_SHORT).show();

            }
        });

        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumDays.setText("");
                mNumPlaces.setText("");
                mNotes.setText("");
                Toast.makeText(PlanYourHoliday.this, "Cleared Feilds", Toast.LENGTH_SHORT).show();
            }
        });

        mViewHolidaysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ViewHolidays.class));
            }
        });
    }
}