package com.example.original;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.original.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.Objects;

public class Account extends AppCompatActivity {

    TextView userName;
    TextView userEmail;
    TextView userMobile;
    TextView userDob;
    Toolbar toolbar;

    UserModel currentUserModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Hide the notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_account);
        userName = findViewById(R.id.profileName);
        userEmail = findViewById(R.id.profileEmail);
        userMobile = findViewById(R.id.profileMobile);
        userDob = findViewById(R.id.profileDob);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getUserData();

        Button editButton = findViewById(R.id.editButton);
        /*editButton.setOnClickListener(v -> {
            Intent intent = new Intent(Account.this,EditProfileActivity.class);
            startActivity(intent);
        });*/
    }

    private void getUserData() {
        FirebaseUtil.currentUserDetails().get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                currentUserModel = task.getResult().toObject(UserModel.class);
                userName.setText(currentUserModel.getName());
                userEmail.setText(currentUserModel.getEmail());
                userMobile.setText(currentUserModel.getMobile());
                userDob.setText(currentUserModel.getDob());
            }
        });
    }
}