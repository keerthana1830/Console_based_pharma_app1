package org.example;

import java.util.Date;

public class Prescription {
    private int prescriptionId;
    private int patientId;
    private int medicationId;
    private int quantity;
    private Date datePrescribed;

    public Prescription(int prescriptionId, int patientId, int medicationId, int quantity, Date datePrescribed) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId;
        this.medicationId = medicationId;
        this.quantity = quantity;
        this.datePrescribed = datePrescribed;
    }

    public int getPrescriptionId() { return prescriptionId; }
    public int getPatientId() { return patientId; }
    public int getMedicationId() { return medicationId; }
    public int getQuantity() { return quantity; }
    public Date getDatePrescribed() { return datePrescribed; }

    @Override
    public String toString() {
        return "Prescription [ID=" + prescriptionId + ", PatientID=" + patientId +
                ", MedicationID=" + medicationId + ", Quantity=" + quantity + ", Date=" + datePrescribed + "]";
    }
}
