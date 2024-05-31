package com.example.cars2;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarsActivity extends AppCompatActivity implements View.OnClickListener {


    private DBManager dbManager;
    Button buttonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.dbManager = new DBManager(new MyAppSQLiteHelper(this,"my_database.db",null,1));
        setContentView(R.layout.activity_car);

        ArrayList<Cars> cars = this.dbManager.loadAllCarsFromDatabase();
        Log.d("load cars",cars.get(0).toString());
        RecyclerView rcView = findViewById(R.id.recyclerView);
        CarsAdapter adapter = new CarsAdapter(cars);
        rcView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        rcView.setAdapter(adapter);

        buttonHome = findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonHome) {
            onBackPressed();
        }
    }
}