package com.example.l2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //Declare the variable so that you will be able to reference it later
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Viehma", "Tokyo", "Beijing", "Osaka", "New Delhi", "Calgary", "London", "Paris"
        , "j", "o", "k", "e", "d", "f", "u", "p"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, dataList);
        cityList.setAdapter(cityAdapter);
        cityList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1,cities);
        EditText editText = findViewById(R.id.hiddenAddCityEditText);

        Button addCityButton = findViewById(R.id.addCityButton);
        Button deleteCityButton = findViewById(R.id.deleteCityButton);
        Button confirmButton = findViewById(R.id.confirm_button);
        Button cancelButton = findViewById(R.id.cancel_button);

        addCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MAKE A SEARCH BAR
                //EditText editText = findViewById(R.id.hiddenAddCityEditText);
                editText.setText("add new City");
                editText.setVisibility(View.VISIBLE);
                confirmButton.setVisibility(View.VISIBLE);
                cancelButton.setVisibility(View.VISIBLE);

            }
        });
        deleteCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Remove selected City
                dataList.remove(cityList.getCheckedItemPosition());
                cityAdapter.notifyDataSetChanged();
            }
        });
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setVisibility(View.INVISIBLE);
                confirmButton.setVisibility(View.INVISIBLE);
                cancelButton.setVisibility(View.INVISIBLE);
                //editText.getText();
                String toAdd = editText.getText().toString();
                dataList.add(toAdd);
                cityAdapter.notifyDataSetChanged();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setVisibility(View.INVISIBLE);
                confirmButton.setVisibility(View.INVISIBLE);
                cancelButton.setVisibility(View.INVISIBLE);
            }
        });


    }
}