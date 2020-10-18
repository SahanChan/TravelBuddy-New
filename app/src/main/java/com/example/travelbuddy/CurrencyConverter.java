package com.example.travelbuddy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CurrencyConverter extends AppCompatActivity {

//
    EditText userValue;
    Button convertButton;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        userValue = (EditText)findViewById(R.id.userVal);
        convertButton = (Button)findViewById(R.id.convertBtn);
        res=(TextView)findViewById(R.id.result);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num =0;
                num= Double.parseDouble(userValue.getText().toString()) * 184;
                res.setText("LKR "+Double.toString(num));
            }
        });
    }
}