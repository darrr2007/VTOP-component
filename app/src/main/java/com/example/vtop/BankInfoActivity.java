package com.example.vtop;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BankInfoActivity extends AppCompatActivity {

    private TextView applicationNumberTextView, bankHolderNameTextView, relationshipTypeTextView,
            accountNumberTextView, reenterAccountNumberTextView, ifscCodeTextView, bankDetailsTextView;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_info2);

        // Initialize Firebase Database
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        // Initialize TextViews
        applicationNumberTextView = findViewById(R.id.applicationNumberTextView);
        bankHolderNameTextView = findViewById(R.id.bankHolderNameTextView);
        relationshipTypeTextView = findViewById(R.id.relationshipTypeTextView);
        accountNumberTextView = findViewById(R.id.accountNumberTextView);
        reenterAccountNumberTextView = findViewById(R.id.reenterAccountNumberTextView);
        ifscCodeTextView = findViewById(R.id.ifscCodeTextView);
        bankDetailsTextView = findViewById(R.id.bankDetailsTextView);

        // Create the userDetails node in the Firebase Realtime Database
        DatabaseReference userDetailsRef = databaseReference.child("userDetails");

        // Retrieve data from the Firebase Realtime Database
        userDetailsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Get the latest user details
                    DataSnapshot userSnapshot = dataSnapshot.getChildren().iterator().next();

                    // Retrieve the required fields
                    UserDetails userDetails = userSnapshot.getValue(UserDetails.class);

                    if (userDetails != null) {
                        // Display the retrieved fields
                        applicationNumberTextView.setText(userDetails.getApplicationNumber());
                        bankHolderNameTextView.setText(userDetails.getBankHolderName());
                        relationshipTypeTextView.setText(userDetails.getRelationshipType());
                        accountNumberTextView.setText(userDetails.getAccountNumber());
                        reenterAccountNumberTextView.setText(userDetails.getReenterAccountNumber());
                        ifscCodeTextView.setText(userDetails.getIfscCode());
                        bankDetailsTextView.setText(userDetails.getBankDetails());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        });
    }

    public static class UserDetails {
        private String applicationNumber;
        private String bankHolderName;
        private String relationshipType;
        private String accountNumber;
        private String reenterAccountNumber;
        private String ifscCode;
        private String bankDetails;

        // Required default constructor for Firebase deserialization
        public UserDetails() {
        }

        public UserDetails(String applicationNumber, String bankHolderName, String relationshipType,
                           String accountNumber, String reenterAccountNumber, String ifscCode,
                           String bankDetails) {
            this.applicationNumber = applicationNumber;
            this.bankHolderName = bankHolderName;
            this.relationshipType = relationshipType;
            this.accountNumber = accountNumber;
            this.reenterAccountNumber = reenterAccountNumber;
            this.ifscCode = ifscCode;
            this.bankDetails = bankDetails;
        }

        public String getApplicationNumber() {
            return applicationNumber;
        }

        public String getBankHolderName() {
            return bankHolderName;
        }

        public String getRelationshipType() {
            return relationshipType;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getReenterAccountNumber() {
            return reenterAccountNumber;
        }

        public String getIfscCode() {
            return ifscCode;
        }

        public String getBankDetails() {
            return bankDetails;
        }
    }
}



