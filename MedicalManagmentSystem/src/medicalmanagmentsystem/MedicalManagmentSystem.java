package medicalmanagmentsystem;
import Factory_DoctorSpcialization.*;
import GUI.*;
import DB.*;

public class MedicalManagmentSystem {


    public static void main(String[] args) {
      DatabaseConnection d1 = DatabaseConnection.getInstance();
      new Login().setVisible(true);
    }
    
}
