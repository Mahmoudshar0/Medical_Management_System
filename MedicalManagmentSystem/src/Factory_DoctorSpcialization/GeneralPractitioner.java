/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory_DoctorSpcialization;

/**
 *
 * @author M_shar
 */
public class GeneralPractitioner extends Doctor{
    public GeneralPractitioner(String name) {
        super(name);
        this.specialization = "General Practitioner";
    }

    @Override
    public void treatPatient() {
        System.out.println("Dr. " + name + " (General Practitioner) is treating a general ailment.");
    }
}
