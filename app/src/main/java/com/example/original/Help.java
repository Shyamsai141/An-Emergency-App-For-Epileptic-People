package com.example.original;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Help extends AppCompatActivity {
    Toolbar toolbar;
    TextView faqPage;
    TextView tacPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Hide the notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_help);
        toolbar = findViewById(R.id.toolbar);
        faqPage = findViewById(R.id.faq);
        tacPage = findViewById(R.id.tc);;


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Help & Support");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tacPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Help.this, TAC.class);
                startActivity(intent);
            }
        });

        faqPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Help.this, FAQs.class);
                startActivity(intent);
            }
        });

    }
}