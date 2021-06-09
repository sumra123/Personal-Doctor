package com.example.Kratin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.yo7a.Kratin.R;

public class AboutApp extends AppCompatActivity {

    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            user = bundle.getString("Usr");
        }
    }


}
