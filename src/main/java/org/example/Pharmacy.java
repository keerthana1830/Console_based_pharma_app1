package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pharmacy {
    private String pharmacyName;
    private String pharmacyId;
    private String pharmacyLocation;
    private String username = "pharmacyAdmin";
    private String password = "pharmacy@123";
    private List<Medication> medicationList = new ArrayList<>();

    // Getters and setters
    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(String pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getPharmacyLocation() {
        return pharmacyLocation;
    }

    public void setPharmacyLocation(String pharmacyLocation) {
        this.pharmacyLocation = pharmacyLocation;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    public boolean login(String username, String password) {
        return username.equals(this.username) && password.equals(this.password);
    }

    public void addMedication(Scanner scanner) {
        System.out.println("Enter Medication Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Description: ");
        String description = scanner.nextLine();
        System.out.println("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter Stock Quantity: ");
        int stockQuantity = scanner.nextInt();
        scanner.nextLine();  // consume the leftover newline

        Medication medication = new Medication();
        medication.setMedicationId("MED" + System.currentTimeMillis());  // Unique ID
        medication.setName(name);
        medication.setDescription(description);
        medication.setPrice(price);
        medication.setStockQuantity(stockQuantity);

        medicationList.add(medication);
        System.out.println("Medication added successfully: " + name);
    }

    public void dispenseMedication(Scanner scanner) {
        System.out.println("Enter Medication ID: ");
        String medicationId = scanner.nextLine();
        Medication medication = findMedicationById(medicationId);

        if (medication != null && medication.getStockQuantity() > 0) {
            System.out.println("Dispense Medication: " + medication.getName());
            System.out.println("Price: " + medication.getPrice());
            medication.setStockQuantity(medication.getStockQuantity() - 1);
            System.out.println("Medication dispensed successfully.");
        } else {
            System.out.println("Medication not found or out of stock.");
        }
    }

    public void viewInventory() {
        System.out.println("===== Medication Inventory =====");
        for (Medication medication : medicationList) {
            System.out.println("ID: " + medication.getMedicationId() + " | Name: " + medication.getName() +
                    " | Price: " + medication.getPrice() + " | Stock: " + medication.getStockQuantity());
        }
    }

    public void checkStock(Scanner scanner) {
        System.out.println("Enter Medication ID to check stock: ");
        String medicationId = scanner.nextLine();
        Medication medication = findMedicationById(medicationId);

        if (medication != null) {
            System.out.println("Stock for " + medication.getName() + ": " + medication.getStockQuantity());
        } else {
            System.out.println("Medication not found.");
        }
    }

    private Medication findMedicationById(String medicationId) {
        for (Medication medication : medicationList) {
            if (medication.getMedicationId().equals(medicationId)) {
                return medication;
            }
        }
        return null;
    }
}

