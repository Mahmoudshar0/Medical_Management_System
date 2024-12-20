/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory_DoctorSpcialization;

/**
 *
 * @author M_shar
 */
public class Cardiologist extends Doctor{
    public Cardiologist(String name) {
        super(name);
        this.specialization = "Cardiologist";
    }

    @Override
    public void treatPatient() {
        System.out.println("Dr. " + name + " (Cardiologist) is treating a heart patient.");
    }
}
