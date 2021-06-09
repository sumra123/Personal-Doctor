package com.example.Kratin;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

import com.example.Kratin.Medical.MedicalProblems;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    ViewPager mViewPager;
Toolbar toolbar;
    // images array
    int[] images = {R.drawable.tip1, R.drawable.tip11, R.drawable.tip222, R.drawable.tip6,
            R.drawable.tip44};

    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // toolbar=(Toolbar)findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        final Handler mHandler = new Handler();
        mViewPager = (ViewPager)findViewById(R.id.viewPager);

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(MainActivity.this, images);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);

        int delay = 1000; // delay for 1 sec.
        int period = 5000; // repeat every 5 sec.
        Timer timer = new Timer();
        final Runnable mUpdateResults = new Runnable() {
            public void run() {

               mViewPager.setAdapter(mViewPagerAdapter);

            }
        };
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                mHandler.post(mUpdateResults);

            }

        }, delay, period);

    }

    public void drreminder(View view) {
        Intent intent=new Intent(getApplicationContext(),AlarmMe.class);
        startActivity(intent);

    }

    public void calories(View view) {
        Intent intent=new Intent(getApplicationContext(),profile.class);
        startActivity(intent);
    }

    public void medical(View view) {
       Intent intent=new Intent(getApplicationContext(), MedicalProblems.class);
       startActivity(intent);

    }

    public void Health(View view) {
        Intent intent=new Intent(getApplicationContext(),Primary.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, (arg0, arg1) -> {

                    MainActivity.super.onBackPressed();
                    finish();
                    System.exit(0);
                }).create().show();
    }

    public void abt(View view) {
        Intent intent=new Intent(MainActivity.this,AboutApp.class);
        startActivity(intent);
    }
}