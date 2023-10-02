package com.example.vtop;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;

    private TextView applicationNumberTextView;
    private TextView studentNameTextView;
    private TextView dateOfBirthTextView;
    private TextView genderTextView;
    private TextView nativeLanguageTextView;
    private TextView nativeStateTextView;
    private TextView bloodGroupTextView;
    private TextView physicallyChallengedTextView;
    private TextView communityTextView;
    private TextView religionTextView;
    private TextView casteTextView;
    private TextView nationalityTextView;
    private TextView hostellerTextView;
    private TextView aadharNumberTextView;
    private TextView mobileNumberTextView;
    private TextView streetNameTextView;
    private TextView areaNameTextView;
    private TextView cityTextView;
    private TextView stateTextView;
    private TextView countryTextView;
    private TextView pincodeTextView;
    private TextView phoneNumberLandlineTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        // Initialize TextView fields
        applicationNumberTextView = findViewById(R.id.applicationNumberTextView);
        studentNameTextView = findViewById(R.id.studentNameTextView);
        dateOfBirthTextView = findViewById(R.id.dateOfBirthTextView);
        nativeLanguageTextView = findViewById(R.id.nativeLanguageTextView);
        nativeStateTextView = findViewById(R.id.nativeStateTextView);
        bloodGroupTextView = findViewById(R.id.bloodGroupTextView);
        physicallyChallengedTextView = findViewById(R.id.physicallyChallengedTextView);
        communityTextView = findViewById(R.id.communityTextView);
        religionTextView = findViewById(R.id.religionTextView);
        casteTextView = findViewById(R.id.casteTextView);
        nationalityTextView = findViewById(R.id.nationalityTextView);
        hostellerTextView = findViewById(R.id.hostellerTextView);
        aadharNumberTextView = findViewById(R.id.aadharNumberTextView);
        mobileNumberTextView = findViewById(R.id.mobileNumberTextView);
        streetNameTextView = findViewById(R.id.streetNameTextView);
        areaNameTextView = findViewById(R.id.areaNameTextView);
        cityTextView = findViewById(R.id.cityTextView);
        stateTextView = findViewById(R.id.stateTextView);
        countryTextView = findViewById(R.id.countryTextView);
        pincodeTextView = findViewById(R.id.pincodeTextView);
        phoneNumberLandlineTextView = findViewById(R.id.phoneNumberLandlineTextView);
        emailTextView = findViewById(R.id.emailTextView);

        // Initialize Firebase Database reference
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

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
//                    UserDetails userDetails = userSnapshot.getValue(UserDetails.class);

//                    if (userDetails != null) {
//
//                    }

                    // Set retrieved data to the corresponding TextView fields
                    applicationNumberTextView.setText(userSnapshot.child("applicationNumber").getValue(String.class));
                    studentNameTextView.setText(userSnapshot.child("studentName").getValue(String.class));
                    dateOfBirthTextView.setText(userSnapshot.child("dateOfBirth").getValue(String.class));
//                    genderTextView.setText(dataSnapshot.child("dateOfBirth").getValue(String.class));
                    nativeLanguageTextView.setText(userSnapshot.child("nativeLanguage").getValue(String.class));
                    nativeStateTextView.setText(userSnapshot.child("nativeState").getValue(String.class));
                    bloodGroupTextView.setText(userSnapshot.child("bloodGroup").getValue(String.class));
                    boolean pc = userSnapshot.child("physicallyChallenged").getValue(Boolean.class);
                    if(pc){
                        physicallyChallengedTextView.setText("True");
                    }else{
                        physicallyChallengedTextView.setText("False");
                    }
                    communityTextView.setText(userSnapshot.child("community").getValue(String.class));
                    religionTextView.setText(userSnapshot.child("religion").getValue(String.class));
                    casteTextView.setText(userSnapshot.child("caste").getValue(String.class));
                    nationalityTextView.setText(userSnapshot.child("nationality").getValue(String.class));
                    boolean hostel = userSnapshot.child("hosteller").getValue(Boolean.class);
                    if(hostel){
                        hostellerTextView.setText("True");
                    }else{
                        hostellerTextView.setText("False");
                    }
                    aadharNumberTextView.setText(userSnapshot.child("aadharNumber").getValue(String.class));
                    mobileNumberTextView.setText(userSnapshot.child("mobileNumber").getValue(String.class));
                    streetNameTextView.setText(userSnapshot.child("streetName").getValue(String.class));
                    areaNameTextView.setText(userSnapshot.child("areaName").getValue(String.class));
                    cityTextView.setText(userSnapshot.child("city").getValue(String.class));
                    stateTextView.setText(userSnapshot.child("state").getValue(String.class));
                    countryTextView.setText(userSnapshot.child("country").getValue(String.class));
                    pincodeTextView.setText(userSnapshot.child("pincode").getValue(String.class));
                    phoneNumberLandlineTextView.setText(userSnapshot.child("phoneNumber").getValue(String.class));
                    emailTextView.setText(userSnapshot.child("email").getValue(String.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle any errors that occur
            }
        });
    }

//    public class UserDetails {
//        private String applicationNumber;
//        private String studentName;
//        private String dateOfBirth;
//        private String gender;
//        private String nativeLanguage;
//        private String nativeState;
//        private String bloodGroup;
//        private String physicallyChallenged;
//        private String community;
//        private String religion;
//        private String caste;
//        private String nationality;
//        private String hosteller;
//        private String aadharNumber;
//        private String mobileNumber;
//        private String streetName;
//        private String areaName;
//        private String city;
//        private String state;
//        private String country;
//        private String pincode;
//        private String phoneNumberLandline;
//        private String email;
//
//        @SuppressWarnings("unused")
//        public UserDetails() {
//            // Default constructor required for Firebase
//        }
//
//        public UserDetails(String applicationNumber, String studentName, String dateOfBirth, String gender,
//                           String nativeLanguage, String nativeState, String bloodGroup, String physicallyChallenged,
//                           String community, String religion, String caste, String nationality, String hosteller,
//                           String aadharNumber, String mobileNumber, String streetName, String areaName, String city,
//                           String state, String country, String pincode, String phoneNumberLandline, String email) {
//            this.applicationNumber = applicationNumber;
//            this.studentName = studentName;
//            this.dateOfBirth = dateOfBirth;
//            this.gender = gender;
//            this.nativeLanguage = nativeLanguage;
//            this.nativeState = nativeState;
//            this.bloodGroup = bloodGroup;
//            this.physicallyChallenged = physicallyChallenged;
//            this.community = community;
//            this.religion = religion;
//            this.caste = caste;
//            this.nationality = nationality;
//            this.hosteller = hosteller;
//            this.aadharNumber = aadharNumber;
//            this.mobileNumber = mobileNumber;
//            this.streetName = streetName;
//            this.areaName = areaName;
//            this.city = city;
//            this.state = state;
//            this.country = country;
//            this.pincode = pincode;
//            this.phoneNumberLandline = phoneNumberLandline;
//            this.email = email;
//        }
//
//        public String getApplicationNumber() {
//            return applicationNumber;
//        }
//
//        public String getStudentName() {
//            return studentName;
//        }
//
//        public String getDateOfBirth() {
//            return dateOfBirth;
//        }
//
//        public String getGender() {
//            return gender;
//        }
//
//        public String getNativeLanguage() {
//            return nativeLanguage;
//        }
//
//        public String getNativeState() {
//            return nativeState;
//        }
//
//        public String getBloodGroup() {
//            return bloodGroup;
//        }
//
//        public String getPhysicallyChallenged() {
//            return physicallyChallenged;
//        }
//
//        public String getCommunity() {
//            return community;
//        }
//
//        public String getReligion() {
//            return religion;
//        }
//
//        public String getCaste() {
//            return caste;
//        }
//
//        public String getNationality() {
//            return nationality;
//        }
//
//        public String getHosteller() {
//            return hosteller;
//        }
//
//        public String getAadharNumber() {
//            return aadharNumber;
//        }
//
//        public String getMobileNumber() {
//            return mobileNumber;
//        }
//
//        public String getStreetName() {
//            return streetName;
//        }
//
//        public String getAreaName() {
//            return areaName;
//        }
//
//        public String getCity() {
//            return city;
//        }
//
//        public String getState() {
//            return state;
//        }
//
//        public String getCountry() {
//            return country;
//        }
//
//        public String getPincode() {
//            return pincode;
//        }
//
//        public String getPhoneNumberLandline() {
//            return phoneNumberLandline;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//    }
}
