package com.example.original;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



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
                else if(id == R.id.nav_logout){
                    Intent intent = new Intent(Dashboard.this, Login.class);
                    startActivity(intent);
                    return true;
                }
                return true;
            }
        });
        android.widget.ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9111111111"));
                startActivity(intent);

            }
        });
    }
}