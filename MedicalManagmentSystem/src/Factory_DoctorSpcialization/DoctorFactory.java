/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory_DoctorSpcialization;

/**
 *
 * @author M_shar
 */
public class DoctorFactory {
    public static Doctor createDoctor(String specialization, String name) {
        switch (specialization.toLowerCase()) {
            case "cardiologist":
                return new Cardiologist(name);
            case "neurologist":
                return new Neurologist(name);
            case "general practitioner":
                return new GeneralPractitioner(name);
            default:
                throw new IllegalArgumentException("Specialization '" + specialization + "' is not recognized.");
        }
    }
}
