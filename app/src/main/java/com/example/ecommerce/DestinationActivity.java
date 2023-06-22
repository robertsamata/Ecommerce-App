package com.example.ecommerce;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class DestinationActivity extends AppCompatActivity {

    String value;
    int count;
    boolean isSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        // Obtinem valorile din intent doar dupa ce activitatea a fost initializata
        value = getIntent().getStringExtra("key");
        count = getIntent().getIntExtra("count", 0);
        isSuccess = getIntent().getBooleanExtra("isSuccess", false);

    }
}