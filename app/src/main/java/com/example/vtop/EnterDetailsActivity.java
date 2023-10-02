package com.example.vtop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EnterDetailsActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details2);

        // Initialize Firebase Database
        databaseReference = FirebaseDatabase.getInstance().getReference("userDetails");

        // Initialize views
        EditText applicationNumberEditText = findViewById(R.id.applicationNumberEditText);
        EditText studentNameEditText = findViewById(R.id.studentNameEditText);
        EditText dateOfBirthEditText = findViewById(R.id.dateOfBirthEditText);
        EditText nativeLanguageEditText = findViewById(R.id.nativeLanguageEditText);
        EditText nativeStateEditText = findViewById(R.id.nativeStateEditText);
        EditText bloodGroupEditText = findViewById(R.id.bloodGroupEditText);
        EditText communityEditText = findViewById(R.id.communityEditText);
        EditText religionEditText = findViewById(R.id.religionEditText);
        EditText casteEditText = findViewById(R.id.casteEditText);
        EditText nationalityEditText = findViewById(R.id.nationalityEditText);
        EditText aadharNumberEditText = findViewById(R.id.aadharNumberEditText);
        EditText mobileNumberEditText = findViewById(R.id.mobileNumberEditText);
        EditText bankHolderNameEditText = findViewById(R.id.bankHolderNameEditText);
        EditText relationshipTypeEditText = findViewById(R.id.relationshipTypeEditText);
        EditText accountNumberEditText = findViewById(R.id.accountNumberEditText);
        EditText reenterAccountNumberEditText = findViewById(R.id.reenterAccountNumberEditText);
        EditText ifscCodeEditText = findViewById(R.id.ifscCodeEditText);
        EditText bankDetailsEditText = findViewById(R.id.bankDetailsEditText);
        EditText streetNameEditText = findViewById(R.id.streetNameEditText);
        EditText areaNameEditText = findViewById(R.id.areaNameEditText);
        EditText cityEditText = findViewById(R.id.cityEditText);
        EditText stateEditText = findViewById(R.id.stateEditText);
        EditText countryEditText = findViewById(R.id.countryEditText);
        EditText pincodeEditText = findViewById(R.id.pincodeEditText);
        EditText phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        EditText emailEditText = findViewById(R.id.emailEditText);
        CheckBox physicallyChallengedCheckBox = findViewById(R.id.physicallyChallengedCheckBox);
        CheckBox hostellerCheckBox = findViewById(R.id.hostellerCheckBox);
        Button submitBtn = findViewById(R.id.submitBtn);

        // Set click listener for Submit button
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered values
                String applicationNumber = applicationNumberEditText.getText().toString();
                String studentName = studentNameEditText.getText().toString();
                String dateOfBirth = dateOfBirthEditText.getText().toString();
                String nativeLanguage = nativeLanguageEditText.getText().toString();
                String nativeState = nativeStateEditText.getText().toString();
                String bloodGroup = bloodGroupEditText.getText().toString();
                String community = communityEditText.getText().toString();
                String religion = religionEditText.getText().toString();
                String caste = casteEditText.getText().toString();
                String nationality = nationalityEditText.getText().toString();
                String aadharNumber = aadharNumberEditText.getText().toString();
                String mobileNumber = mobileNumberEditText.getText().toString();
                String bankHolderName = bankHolderNameEditText.getText().toString();
                String relationshipType = relationshipTypeEditText.getText().toString();
                String accountNumber = accountNumberEditText.getText().toString();
                String reenterAccountNumber = reenterAccountNumberEditText.getText().toString();
                String ifscCode = ifscCodeEditText.getText().toString();
                String bankDetails = bankDetailsEditText.getText().toString();
                String streetName = streetNameEditText.getText().toString();
                String areaName = areaNameEditText.getText().toString();
                String city = cityEditText.getText().toString();
                String state = stateEditText.getText().toString();
                String country = countryEditText.getText().toString();
                String pincode = pincodeEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();
                String email = emailEditText.getText().toString();
                boolean isPhysicallyChallenged = physicallyChallengedCheckBox.isChecked();
                boolean isHosteller = hostellerCheckBox.isChecked();

                // Create a unique ID for the user details
                String userId = databaseReference.push().getKey();

                // Create a User object with the retrieved values
                XYZ userDetails = new XYZ(userId, applicationNumber, studentName, dateOfBirth, nativeLanguage, nativeState,
                        bloodGroup, community, religion, caste, nationality, aadharNumber, mobileNumber, bankHolderName,
                        relationshipType, accountNumber, reenterAccountNumber, ifscCode, bankDetails, streetName, areaName,
                        city, state, country, pincode, phoneNumber, email, isPhysicallyChallenged, isHosteller);

                // Save the user details to the Firebase database
                if (userId != null) {
                    databaseReference.child(userId).setValue(userDetails);
                }

                // Display a success message
                Toast.makeText(EnterDetailsActivity.this, "User details saved successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class XYZ {
        private String userId;
        private String applicationNumber;
        private String studentName;
        private String dateOfBirth;
        private String nativeLanguage;
        private String nativeState;
        private String bloodGroup;
        private String community;
        private String religion;
        private String caste;
        private String nationality;
        private String aadharNumber;
        private String mobileNumber;
        private String bankHolderName;
        private String relationshipType;
        private String accountNumber;
        private String reenterAccountNumber;
        private String ifscCode;
        private String bankDetails;
        private String streetName;
        private String areaName;
        private String city;
        private String state;
        private String country;
        private String pincode;
        private String phoneNumber;
        private String email;
        private boolean isPhysicallyChallenged;
        private boolean isHosteller;

        public XYZ() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public XYZ(String userId, String applicationNumber, String studentName, String dateOfBirth, String nativeLanguage,
                    String nativeState, String bloodGroup, String community, String religion, String caste,
                    String nationality, String aadharNumber, String mobileNumber, String bankHolderName,
                    String relationshipType, String accountNumber, String reenterAccountNumber, String ifscCode,
                    String bankDetails, String streetName, String areaName, String city, String state, String country,
                    String pincode, String phoneNumber, String email, boolean isPhysicallyChallenged, boolean isHosteller) {
            this.userId = userId;
            this.applicationNumber = applicationNumber;
            this.studentName = studentName;
            this.dateOfBirth = dateOfBirth;
            this.nativeLanguage = nativeLanguage;
            this.nativeState = nativeState;
            this.bloodGroup = bloodGroup;
            this.community = community;
            this.religion = religion;
            this.caste = caste;
            this.nationality = nationality;
            this.aadharNumber = aadharNumber;
            this.mobileNumber = mobileNumber;
            this.bankHolderName = bankHolderName;
            this.relationshipType = relationshipType;
            this.accountNumber = accountNumber;
            this.reenterAccountNumber = reenterAccountNumber;
            this.ifscCode = ifscCode;
            this.bankDetails = bankDetails;
            this.streetName = streetName;
            this.areaName = areaName;
            this.city = city;
            this.state = state;
            this.country = country;
            this.pincode = pincode;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.isPhysicallyChallenged = isPhysicallyChallenged;
            this.isHosteller = isHosteller;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getApplicationNumber() {
            return applicationNumber;
        }

        public void setApplicationNumber(String applicationNumber) {
            this.applicationNumber = applicationNumber;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getNativeLanguage() {
            return nativeLanguage;
        }

        public void setNativeLanguage(String nativeLanguage) {
            this.nativeLanguage = nativeLanguage;
        }

        public String getNativeState() {
            return nativeState;
        }

        public void setNativeState(String nativeState) {
            this.nativeState = nativeState;
        }

        public String getBloodGroup() {
            return bloodGroup;
        }

        public void setBloodGroup(String bloodGroup) {
            this.bloodGroup = bloodGroup;
        }

        public String getCommunity() {
            return community;
        }

        public void setCommunity(String community) {
            this.community = community;
        }

        public String getReligion() {
            return religion;
        }

        public void setReligion(String religion) {
            this.religion = religion;
        }

        public String getCaste() {
            return caste;
        }

        public void setCaste(String caste) {
            this.caste = caste;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getAadharNumber() {
            return aadharNumber;
        }

        public void setAadharNumber(String aadharNumber) {
            this.aadharNumber = aadharNumber;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getBankHolderName() {
            return bankHolderName;
        }

        public void setBankHolderName(String bankHolderName) {
            this.bankHolderName = bankHolderName;
        }

        public String getRelationshipType() {
            return relationshipType;
        }

        public void setRelationshipType(String relationshipType) {
            this.relationshipType = relationshipType;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getReenterAccountNumber() {
            return reenterAccountNumber;
        }

        public void setReenterAccountNumber(String reenterAccountNumber) {
            this.reenterAccountNumber = reenterAccountNumber;
        }

        public String getIfscCode() {
            return ifscCode;
        }

        public void setIfscCode(String ifscCode) {
            this.ifscCode = ifscCode;
        }

        public String getBankDetails() {
            return bankDetails;
        }

        public void setBankDetails(String bankDetails) {
            this.bankDetails = bankDetails;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isPhysicallyChallenged() {
            return isPhysicallyChallenged;
        }

        public void setPhysicallyChallenged(boolean physicallyChallenged) {
            isPhysicallyChallenged = physicallyChallenged;
        }

        public boolean isHosteller() {
            return isHosteller;
        }

        public void setHosteller(boolean hosteller) {
            isHosteller = hosteller;
        }
// Getters and setters for all fields
    }
}
