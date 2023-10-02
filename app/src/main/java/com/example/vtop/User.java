package com.example.vtop;

public class User {
    private String userId;
    private String username;
    private String email;
    private String password;

    public User() {
        // Default constructor required for Firebase
    }

    public User(String userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

//    public User(String userId, String applicationNumber, String studentName, String dateOfBirth, String nativeLanguage, String nativeState, String bloodGroup, String community, String religion, String caste, String nationality, String aadharNumber, String mobileNumber, String bankHolderName, String relationshipType, String accountNumber, String reenterAccountNumber, String ifscCode, String bankDetails, String streetName, String areaName, String city, String state, String country, String pincode, String phoneNumber, String email, boolean isPhysicallyChallenged, boolean isHosteller) {
//    }
//
//    public User(String userId, String applicationNumber, String studentName) {
//    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    protected String getApplicationNumber() {
        return null;
    }
}

