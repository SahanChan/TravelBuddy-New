package com.example.travelbuddy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WeatherClimate extends AppCompatActivity {


    EditText cityText;

    TextView cityName;
    TextView temp;
    TextView desc;
    ImageView weather_image;
    Button searchBtn;

    private static final String TAG = "WeatherClimate";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_climate);
        searchBtn = (Button) findViewById(R.id.searchButton);
        cityName = findViewById(R.id.cityName);

        temp = findViewById(R.id.temperature);
        weather_image =(ImageView)findViewById(R.id.weatherImage);


        desc = findViewById(R.id.desc);

        cityText = findViewById(R.id.city);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cityName.setText(cityText.getText().toString());
                temp.setText("29°C");

                desc.setText("Sunny");
                weather_image.setImageResource(R.drawable.d02d);
            }
        });
    }
}

