package com.example.vtop;

public class UserDetails extends User {
    private final String applicationNumber;
    private final String userId2;
    private final String studentName;
    private final String dateOfBirth;
    private final String nativeLanguage;
    private final String nativeState;
    private final String bloodGroup;
    private final String community;
    private final String religion;
    private final String caste;
    private final String nationality;
    private final String aadharNumber;
    private final String mobileNumber;
    private final String bankHolderName;
    private final String relationshipType;
    private final String accountNumber;
    private final String reenterAccountNumber;
    private final String ifscCode;
    private final String bankDetails;
    private final String streetName;
    private final String areaName;
    private final String city;
    private final String state;
    private final String country;
    private final String pincode;
    private final String phoneNumber;
    private final String email;
    private final boolean isPhysicallyChallenged;
    private final boolean isHosteller;


    public UserDetails(String userId2, String applicationNumber, String studentName, String dateOfBirth, String nativeLanguage, String nativeState, String bloodGroup, String community, String religion, String caste, String nationality, String aadharNumber, String mobileNumber, String bankHolderName, String relationshipType, String accountNumber, String reenterAccountNumber, String ifscCode, String bankDetails, String streetName, String areaName, String city, String state, String country, String pincode, String phoneNumber, String email, boolean isPhysicallyChallenged, boolean isHosteller) {
        this.userId2 = userId2;
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

    @Override
    public String getApplicationNumber() {
        return super.getApplicationNumber();
    }


}
