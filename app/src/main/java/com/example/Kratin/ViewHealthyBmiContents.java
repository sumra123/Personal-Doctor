package com.example.Kratin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class ViewHealthyBmiContents extends AppCompatActivity {

    DataBaseHelper myDB;
    ArrayList<User1> userList;
    ListView listView;
    User1 user;
    Button deleteButton;
    EditText enterNameEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_healthy_bmi);
      //  ActionBar actionBar=getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        myDB = new DataBaseHelper(this);

        deleteButton = findViewById(R.id.deleteEntryButton);
        enterNameEditText = findViewById(R.id.enterNameEditText);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.deleteProduct(enterNameEditText.getText().toString());
                startActivity(new Intent(ViewHealthyBmiContents.this, profile.class));
            }
        });

        userList = new ArrayList<>();
        Cursor data = myDB.getHealthyBmiContents();
        int numRows = data.getCount();
        if (numRows == 0) {
            Toast.makeText(ViewHealthyBmiContents.this, "The Database is empty.", Toast.LENGTH_LONG).show();
        } else {
            int i = 0;
            while (data.moveToNext()) {
                user = new User1(data.getString(0), data.getInt(1), data.getInt(2), data.getDouble(3));
                userList.add(i, user);
                i++;
            }
            FourColumn_ListAdapter adapter = new FourColumn_ListAdapter(this, R.layout.list_adapter_view, userList);
            listView = (ListView) findViewById(R.id.listView);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(ViewHealthyBmiContents.this, CaloriesGraph.class);
                    intent.putExtra("DailyCaloricIntake", listView.getItemAtPosition(i).toString()); //get the listView item we clicked at's dailyCaloricIntake
                    startActivity(intent);
                }
            });
            listView.setAdapter(adapter);
        }
    }


}
