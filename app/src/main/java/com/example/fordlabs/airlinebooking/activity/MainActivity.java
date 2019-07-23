package com.example.fordlabs.airlinebooking.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.fordlabs.airlinebooking.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mainView(View v)
    {

        Intent i = new Intent(getApplicationContext(),SecondActivity.class);

        EditText origintext = findViewById(R.id.origin);
        EditText destText = findViewById(R.id.destination);
        EditText dateText = findViewById(R.id.date);


        i.putExtra("origin",origintext.getText().toString());
        i.putExtra("destination",destText.getText().toString());
        i.putExtra("date",dateText.getText().toString());

        startActivity(i);

    }
}
