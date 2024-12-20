/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ProtoType.*;
/**
 *
 * @author M_shar
 */
public class PatientAdapterImpl implements PatientAdapter{
    
       private Map<Integer, Patient> patients;

    public PatientAdapterImpl() {
        patients = new HashMap<>();
    }

    @Override
    public void addPatient(Patient patient) {
        patients.put(patient.getPatientID(), patient);
        System.out.println("تم إضافة المريض: " + patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        if (patients.containsKey(patient.getPatientID())) {
            patients.put(patient.getPatientID(), patient);
            System.out.println("تم تحديث المريض: " + patient);
        } else {
            System.out.println("المريض غير موجود!");
        }
    }

    @Override
    public void deletePatient(int id) {
        if (patients.containsKey(id)) {
            patients.remove(id);
            System.out.println("تم حذف المريض بالمعرف: " + id);
        } else {
            System.out.println("المريض غير موجود!");
        }
    }

    @Override
    public Patient getPatientById(int id) {
        return patients.get(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients.values());
    }
    
}
