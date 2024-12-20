/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory_DoctorSpcialization;

/**
 *
 * @author M_shar
 */
public class Neurologist extends Doctor{
    public Neurologist(String name) {
        super(name);
        this.specialization = "Neurologist";
    }

    @Override
    public void treatPatient() {
        System.out.println("Dr. " + name + " (Neurologist) is treating a nervous system patient.");
    }
}
