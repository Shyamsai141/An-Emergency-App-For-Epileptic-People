package com.example.original;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import org.w3c.dom.Text;

import java.util.Objects;

public class Signup extends AppCompatActivity {

    private EditText editTextRegisterPwd, editTextRegisterConfirmPwd, editTextRegisterEmail;
    //

    private static final String TAG = "Signup";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Hide the notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_signup);

        //getSupportActionBar().setTitle("Sign up");
        Toast.makeText(this, "Sign up", Toast.LENGTH_SHORT).show();

        editTextRegisterEmail = findViewById(R.id.email);
        editTextRegisterPwd = findViewById(R.id.password);
        editTextRegisterConfirmPwd = findViewById(R.id.cnpassword);
        TextView btLogin = findViewById(R.id.backtologin);
      //  progressBar = findViewById(R.id.progressBar);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        Button buttonSignup = findViewById(R.id.button_signup);
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtEmail = editTextRegisterEmail.getText().toString();
                String txtPwd = editTextRegisterPwd.getText().toString();
                String txtConfirmPwd = editTextRegisterConfirmPwd.getText().toString();

                if(TextUtils.isEmpty(txtEmail)) {
                    Toast.makeText(Signup.this, "Please Enter email", Toast.LENGTH_SHORT).show();
                    editTextRegisterEmail.setError("Enter Email id");
                    editTextRegisterEmail.requestFocus();
                } else if(!Patterns.EMAIL_ADDRESS.matcher(txtEmail).matches()){
                    Toast.makeText(Signup.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
                    editTextRegisterEmail.setError("Enter valid email");
                    editTextRegisterEmail.requestFocus();
                } else if(TextUtils.isEmpty(txtPwd)) {
                    Toast.makeText(Signup.this, "Please Enter password", Toast.LENGTH_SHORT).show();
                    editTextRegisterPwd.setError("Enter password");
                    editTextRegisterPwd.requestFocus();
                } else if(txtPwd.length() < 5){
                    Toast.makeText(Signup.this, "password too weak", Toast.LENGTH_SHORT).show();
                    editTextRegisterPwd.setError("Password is too weak");
                    editTextRegisterPwd.requestFocus();
                } else if(TextUtils.isEmpty(txtConfirmPwd)){
                    Toast.makeText(Signup.this, "Please confirm password", Toast.LENGTH_SHORT).show();
                    editTextRegisterConfirmPwd.setError("Confirm password");
                    editTextRegisterConfirmPwd.requestFocus();
                } else if(!txtPwd.equals(txtConfirmPwd)){
                    Toast.makeText(Signup.this, "Passwords does not match", Toast.LENGTH_SHORT).show();
                    editTextRegisterConfirmPwd.setError("Passwords does not match");
                    editTextRegisterConfirmPwd.requestFocus();
                    editTextRegisterPwd.getText().clear();
                    editTextRegisterConfirmPwd.getText().clear();
                } else{
                    //  progressBar.setVisibility(View.VISIBLE);
                    signupUser(txtEmail, txtPwd);
                }
            }
        });
    }

    private void signupUser(String txtEmail, String txtPwd) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(txtEmail, txtPwd).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Signup.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Signup.this, MainActivity.class);
                    intent.putExtra("email", txtEmail);
                    startActivity(intent);
                    finish();
                } else {
                    try {
                        throw Objects.requireNonNull(task.getException());
                    } catch (FirebaseAuthWeakPasswordException e){
                        editTextRegisterPwd.setError("Password is too weak");
                        editTextRegisterPwd.requestFocus();
                    } catch (FirebaseAuthInvalidCredentialsException e){
                        editTextRegisterPwd.setError("Password doesn't match");
                        editTextRegisterPwd.requestFocus();
                    } catch (FirebaseAuthUserCollisionException e){
                        editTextRegisterEmail.setError("User with this mail already exist!");
                        editTextRegisterEmail.requestFocus();
                    } catch (Exception e){
                        Log.e(TAG, Objects.requireNonNull(e.getMessage()));
                        Toast.makeText(Signup.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    // progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}