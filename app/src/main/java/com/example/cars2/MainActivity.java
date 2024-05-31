package com.example.cars2;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button enterButton;
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.enterButton){
            Intent intent = new Intent(this,AppActivity.class);
            startActivityForResult(intent,12345);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        enterButton = findViewById(R.id.enterButton);
        enterButton.setOnClickListener(this);
    }



}

