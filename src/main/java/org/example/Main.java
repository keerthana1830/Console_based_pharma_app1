package org.example;

import java.util.Scanner;

public class Main {

    private static void softwareDescription() {
        System.out.println("================================");
        System.out.println("===PHARMACY MANAGEMENT SYSTEM===");
        System.out.println("================================");
    }

    private static void options() {
        System.out.println("1. Pharmacy Login");
        System.out.println("2. Customer Login");
        System.out.println("3. Close application");
        System.out.println("Choose options:");
    }

    private static void pharmacyOptions() {
        System.out.println("0. Add Medication");
        System.out.println("1. Dispense Medication");
        System.out.println("2. View Medication Inventory");
        System.out.println("3. Check Medication Stock");
        System.out.println("4. Logout");
        System.out.println("5. Close the application");
    }

    private static void onSuccessLogin(Scanner scanner, Pharmacy pharmacy) {
        System.out.println("Successfully Logged In");
        while(true) {
            pharmacyOptions();
            int pharmacyChoice = scanner.nextInt();
            scanner.nextLine();
            if (pharmacyChoice == 0) {
                pharmacy.addMedication(scanner);
            } else if (pharmacyChoice == 1) {
                pharmacy.dispenseMedication(scanner);
            } else if (pharmacyChoice == 2) {
                pharmacy.viewInventory();
            } else if (pharmacyChoice == 3) {
                pharmacy.checkStock(scanner);
            } else if (pharmacyChoice == 4) {
                break;
            } else if (pharmacyChoice == 5) {
                System.exit(0);
            } else{
                System.out.println("Invalid Choice");
            }
        }
    }

    private static void pharmacyLogin(Scanner scanner, Pharmacy pharmacy) {
        System.out.println("Enter username: ");
        scanner.nextLine();
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        boolean isLogInSuccessful = pharmacy.login(username, password);
        if (isLogInSuccessful) {
            onSuccessLogin(scanner, pharmacy);
        } else {
            System.out.println("Sorry, wrong username/password");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setPharmacyName("HealthCare Pharmacy");
        pharmacy.setPharmacyId("HCP001");
        pharmacy.setPharmacyLocation("Main Street, City");

        while(true) {
            softwareDescription();
            options();
            int choice = scanner.nextInt();
            if (choice == 1) {
                pharmacyLogin(scanner, pharmacy);
            } else if (choice == 2) {
                // Customer Login logic (could be added later)
            } else {
                break;
            }
        }
    }
}
