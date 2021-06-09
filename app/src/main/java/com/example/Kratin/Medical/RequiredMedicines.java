/*
 * %W% %E% Zain-Ul-Abedin
 *
 * Copyright (c) 2017-2018. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of ZainMustafaaa.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * for learning purposes.
 *
 */

package com.example.Kratin.Medical;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import android.view.GestureDetector;
import com.example.yo7a.Kratin.Web.WebsiteView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Kratin.R;

public class RequiredMedicines extends AppCompatActivity {

    /** gestureDetectorCompat variable */
    private GestureDetectorCompat gestureDetectorCompat;
    /** medicineNames, descriptions, images array */
    private int[] medicineNames, descriptions, images;
    /** medicineName medicineDescription medicineIndes textView variables */
    private TextView medicineName, medicineDescription, medicineIndex;
    /** imageView variable for medicines image view */
    private ImageView medicineImage;
    /** index for array details and total medicines */
    byte index = 0, TOTAL_MEDICINES;

    /**
     * override onCreate method
     * @param savedInstanceState
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActionBar actionBar=getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        this.setTitle(getResources().getStringArray(R.array.medicalProblems)[MedicinesController.index]);

        /** initializing medicines descriptions and images variables */
        medicineNames = MedicinesController.getMedicines();
        descriptions = MedicinesController.getDescriptions();
        images = MedicinesController.getImagesId();

        /** totalMedicines byte variable */
        TOTAL_MEDICINES = (byte) medicineNames.length;

        /** settingUp layout content  */
        setContentView(R.layout.activity_required_medicines);
        /** initializing gestures */
        gestureDetectorCompat = new GestureDetectorCompat(this, new Gesture());

        /** settingUp setOnClickMethod for buyOnline method
         * @param OnClickListener
         * */
        findViewById(R.id.onlineBuyButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyOnline(view);
            }
        });

        /** initializing medicineName medicineDescription medicineImage and medicineIndex variables */
        medicineName = (TextView) findViewById(R.id.medicineName);
        medicineDescription = (TextView) findViewById(R.id.medicineDescription);
        medicineImage = (ImageView) findViewById(R.id.medicineImage);
        medicineIndex = (TextView) findViewById(R.id.indexView);


        fillData(index);

    }


    void buyOnline(View view){
        MedicinesController.index1 = index;

        Intent intent = new Intent(RequiredMedicines.this, WebsiteView.class);
        startActivity(intent);
    }


    public boolean onTouchEvent(MotionEvent motionEvent){
        this.gestureDetectorCompat.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }


    void fillData(byte i){
        medicineName.setText(medicineNames[i]);
        medicineDescription.setText(descriptions[i]);
        medicineImage.setImageResource(images[i]);

        medicineIndex.setText((i+1)+"/"+TOTAL_MEDICINES);
    }


    class Gesture extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            
            if(e2.getX()<e1.getX()){
                if(index<TOTAL_MEDICINES-1){
                    index++;
                    fillData(index);
                }
            }
            else if(e2.getX()>e1.getX()) {
                if (index>0){
                    index--;
                    fillData(index);
                }
            }

            return true;
        }
    }
}
