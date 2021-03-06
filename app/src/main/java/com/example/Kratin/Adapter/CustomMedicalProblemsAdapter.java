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
package com.example.Kratin.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yo7a.Kratin.R;

import java.util.ArrayList;


public class CustomMedicalProblemsAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<Integer> idImages;
    private ArrayList<String> textViewList;

    public CustomMedicalProblemsAdapter(Context context, ArrayList<Integer> listId, ArrayList<String> textViewList) {
        this.context = context;
        this.idImages = listId;
        this.textViewList = textViewList;
    }

    /**
     * getCount override method
     * @return textViewList.size
     */
    @Override
    public int getCount() {
        return textViewList.size();
    }

    /**
     * override getItem method
     * @param i
     * @return Object
     * */
    @Override
    public Object getItem(int i) {
        return textViewList.get(i);
    }

    /**
     * override getItemId method
     * @param i
     * @return long
     * */
    @Override
    public long getItemId(int i) {
        return idImages.get(i);
    }

    /**
     * override getView method
     * @param i
     * @param view
     * @param viewGroup
     * @return view
     * */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = view.inflate(context, R.layout.medical_problems_list_design, null);
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.medicalProblemImage);
        TextView textView = (TextView) view.findViewById(R.id.medicalProblemText);

        imageView.setImageResource(idImages.get(i));
        textView.setText(textViewList.get(i));

        return view;
    }
}
