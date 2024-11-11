package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<Medication> purchasedMedications = new ArrayList<>();

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Medication> getPurchasedMedications() {
        return purchasedMedications;
    }

    public void setPurchasedMedications(List<Medication> purchasedMedications) {
        this.purchasedMedications = purchasedMedications;
    }
}
