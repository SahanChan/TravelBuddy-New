package com.example.travelbuddy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProvideFeedback extends AppCompatActivity {
    Button sendBtn;
    Button clearBtn;
    EditText feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_feedback);

        sendBtn = (Button) findViewById(R.id.sendBtn);
        clearBtn =(Button) findViewById(R.id.clearBtn);
        feedback = (EditText)findViewById(R.id.feedbackAns);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedback.setText("");
                Toast.makeText(ProvideFeedback.this, "Sending Feedback", Toast.LENGTH_SHORT).show();
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedback.setText("");
            }
        });
    }
}