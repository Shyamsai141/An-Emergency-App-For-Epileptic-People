package com.example.original;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Wallet extends AppCompatActivity {

    private double balance = 0.0;
    private EditText amountEditText;
    private TextView balanceTextView;
    private RadioGroup paymentRadioGroup;
    private DatabaseReference walletReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_wallet);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Wallet");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        amountEditText = findViewById(R.id.amountEditText);
        balanceTextView = findViewById(R.id.balanceTextView);
        paymentRadioGroup = findViewById(R.id.paymentRadioGroup);

        // Get the current authenticated user
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser != null) {
            // Reference for the current user's wallet
            walletReference = FirebaseDatabase.getInstance().getReference("wallets")
                    .child(currentUser.getUid());

            // Retrieve the current balance from Firebase
            retrieveBalance();

            Button addButton = findViewById(R.id.addButton);
            Button withdrawButton = findViewById(R.id.withdrawButton);

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addAmountToWallet();
                }
            });

            withdrawButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    withdrawAmountFromWallet();
                }
            });
        } else {
            // If there's no authenticated user, handle it appropriately
            Toast.makeText(this, "User is not authenticated. Please log in.",
                    Toast.LENGTH_SHORT).show();
            finish();  // Close the activity if no user is logged in
        }
    }

    private void addAmountToWallet() {
        int selectedRadioButtonId = paymentRadioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId == -1) {
            Toast.makeText(this, "Please select a payment method",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        String amountStr = amountEditText.getText().toString();
        if (!amountStr.isEmpty()) {
            double amount = Double.parseDouble(amountStr);
            balance += amount;

            // Update Firebase with the new balance
            walletReference.setValue(balance);

            updateBalanceDisplay();

            amountEditText.setText("");
            paymentRadioGroup.clearCheck();
            Toast.makeText(this, "Amount added to wallet",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please enter an amount",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void withdrawAmountFromWallet() {
        String amountStr = amountEditText.getText().toString();
        if (!amountStr.isEmpty()) {
            double amount = Double.parseDouble(amountStr);
            if (amount <= balance) {
                balance -= amount;

                // Update Firebase with the new balance
                walletReference.setValue(balance);

                updateBalanceDisplay();

                amountEditText.setText("");
                paymentRadioGroup.clearCheck();
                Toast.makeText(this, "Amount withdrawn from wallet",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Insufficient balance",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter an amount",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void updateBalanceDisplay() {
        balanceTextView.setText(String.format("Balance: Rs. %.2f", balance));
    }

    private void retrieveBalance() {
        walletReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Double storedBalance = dataSnapshot.getValue(Double.class);
                if (storedBalance != null) {
                    balance = storedBalance;
                    updateBalanceDisplay();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Wallet.this, "Error fetching balance",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
