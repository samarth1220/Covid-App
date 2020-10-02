package com.defiance.confine;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CovidCasesActivity extends AppCompatActivity {

    private TextView text1, text2, text3, text4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_cases);

        text1 = findViewById(R.id.total_cases_2);
        text2 = findViewById(R.id.active_cases_2);
        text3 = findViewById(R.id.recovered);
        text4 = findViewById(R.id.deceased);

        text1.setText(AssesmentFormFragment.map.get("totalCases"));
        text2.setText(AssesmentFormFragment.map.get("activeCases"));
        text3.setText(AssesmentFormFragment.map.get("recovered"));
        text4.setText(AssesmentFormFragment.map.get("deaths"));
    }
}