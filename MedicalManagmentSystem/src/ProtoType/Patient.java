/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProtoType;

/**
 *
 * @author M_shar
 */
public class Patient implements Cloneable{
    
    private int PatientID;
    private String FristName;
    private String LastName;
    private String DateOfBirth;
    private String Gender;
    private String Phone;
    private String Email;
    private String Address;

    // Constructor
    public Patient(int PatientID, String FristName, String LastName, String DateOfBirth, String Gender, String Phone, String Email, String Address) {
        this.PatientID = PatientID;
        this.FristName = FristName;
        this.LastName = LastName;
        this.DateOfBirth = DateOfBirth;
        this.Gender = Gender;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
    }

    // Getters
    public int getPatientID() {
        return PatientID;
    }

    public String getFristName() {
        return FristName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    // Clone method to create a copy of the patient
    @Override
    public Patient clone() {
        try {
            // Call the super.clone() method to create a shallow copy
            return (Patient) super.clone();
        } catch (CloneNotSupportedException e) {
            // This exception will be thrown if the class does not implement Cloneable
            System.out.println("Cloning failed: " + e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "Patient{" +
                "PatientID=" + PatientID +
                ", FristName='" + FristName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
    
