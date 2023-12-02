package com.example.original;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Success extends AppCompatActivity {

    Button backl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        backl = findViewById(R.id.back);
        backl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backlogging();
                finish();
            }
        });
    }
    public void backlogging() {
        Intent intent = new Intent(Success.this, Login.class);
        startActivity(intent);
    }
}