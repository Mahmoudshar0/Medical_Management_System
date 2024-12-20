/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

import java.util.List;
import ProtoType.*;

/**
 *
 * @author M_shar
 */
public interface PatientAdapter {
    void addPatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(int id);
    Patient getPatientById(int id);
    List<Patient> getAllPatients();
}
