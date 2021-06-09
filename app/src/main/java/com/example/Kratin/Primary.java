package com.example.Kratin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Primary extends AppCompatActivity {

    private String user;
    private int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary);


        ImageButton VitalSigns = this.findViewById(R.id.VS);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user = extras.getString("Usr");
            //The key argument here must match that used in the other activity
        }




        //Every Test Button sends the username + the test number, to go to the wanted test after the instructions activity





        VitalSigns.setOnClickListener(v -> {
            p = 5;
            Intent i = new Intent(v.getContext(), StartVitalSigns.class);
            i.putExtra("Usr", user);
            i.putExtra("Page", p);
            startActivity(i);
            finish();
        });

    }



}

