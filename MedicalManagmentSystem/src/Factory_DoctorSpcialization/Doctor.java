/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory_DoctorSpcialization;

/**
 *
 * @author M_shar
 */
public abstract class Doctor {
    protected String name;
    protected String specialization;

    public Doctor(String name) {
        this.name = name;
    }

    public abstract void treatPatient();

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}
