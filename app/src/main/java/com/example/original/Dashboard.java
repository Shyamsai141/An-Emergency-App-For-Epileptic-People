package com.example.original;

import androidx.annotation.NonNull;
import android.Manifest;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.original.model.UserModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.DocumentSnapshot;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Dashboard extends AppCompatActivity{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    EditText name;
    EditText mobile;
    UserModel currentUserModel;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;
    private FusedLocationProviderClient fusedLocationClient;
    private TextView locationTextView;
    private TextView addressTextView;
    private EditText location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Hide the notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          .nav_view);
        toolbar = findViewById(R.id.toolbar);
        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        locationTextView = findViewById(R.id.locationTextView);
        addressTextView = findViewById(R.id.addressTextView);
        location = findViewById(R.id.location);


        getUserData();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("EpiCare");

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(Dashboard.this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        ImageView sos = findViewById(R.id.sosButton);
        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.nav_home){
                    Intent intent = new Intent(Dashboard.this,Account.class);
                    startActivity(intent);
                    return true;
                }
                else if(id == R.id.nav_help){
                    Toast.makeText(Dashboard.this, "help", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Dashboard.this,Help.class));
                    return true;
                }
                else if(id == R.id.settings) {
                    Toast.makeText(Dashboard.this, "settings", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Dashboard.this,Settings.class));
                    return true;
                }
                else if(id == R.id.nav_healthReport){
                    Intent intent = new Intent(Dashboard.this,Medicalreport.class);
                    startActivity(intent);
                    return true;
                }
                else if(id == R.id.nav_wallet){
                    Intent intent = new Intent(Dashboard.this, Wallet.class);
                    startActivity(intent);
                    return true;
                }
                return true;
            }
        });

    }
    private void getUserData() {
        FirebaseUtil.currentUserDetails().get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                currentUserModel = task.getResult().toObject(UserModel.class);
                name.setText(currentUserModel.getName());
                mobile.setText(currentUserModel.getMobile());
            }
        });
    }
    private void getLocation(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                double latitude = location.getLatitude();
                                double longitude = location.getLongitude();
                                locationTextView.setText("Latitude: " + latitude + "\nLongitude: " + longitude);

                                // Reverse geocoding to get address
                                getAddressFromLocation(latitude, longitude);
                            } else {
                                locationTextView.setText("Location not available");
                            }
                        }
                    });
        }

    }

    private void getAddressFromLocation(double latitude, double longitude) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                StringBuilder addressText = new StringBuilder();
                for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
                    addressText.append(address.getAddressLine(i)).append("\n");
                }
                location.setText(addressText.toString());
            } else {
                location.setText("Address not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
            location.setText("Error: " + e.getMessage());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            }
        }
    }

}