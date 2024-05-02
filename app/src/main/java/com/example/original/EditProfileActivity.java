package com.example.original;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.original.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class EditProfileActivity extends AppCompatActivity {

    Toolbar toolbar;
    private EditText newName;
    private EditText newMobile;
    private EditText newDob;
    UserModel currentUserModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Hide the notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_edit_profile);
        toolbar = findViewById(R.id.toolbar);
        newName = findViewById(R.id.editName);
        newDob = findViewById(R.id.editDob);
        newMobile = findViewById(R.id.editMobile);


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button updateBtn = findViewById(R.id.saveButton);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfile();
            }
        });
    }

    private void updateProfile() {
        String reName = newName.getText().toString();
        String reMobile = newMobile.getText().toString();
        String reDob = newDob.getText().toString();
        currentUserModel.setName(reName);
        currentUserModel.setName(reMobile);
        currentUserModel.setDob(reDob);
        updateFirestore();
        returnToprofile();
    }

    private void returnToprofile() {
        Intent intent = new Intent(EditProfileActivity.this, Account.class);
        startActivity(intent);
        finish();
    }

    private void updateFirestore() {
        FirebaseUtil.currentUserDetails().set(currentUserModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(EditProfileActivity.this, "updated successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(EditProfileActivity.this, "not updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}