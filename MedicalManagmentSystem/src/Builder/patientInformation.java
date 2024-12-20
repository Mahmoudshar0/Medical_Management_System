/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

/**
 *
 * @author Start
 */
public class patientInformation {
    private int RecordID;
    private int patientID;
    private int DecoderID;
    private int RecordDate;
    private String Description;
   public  patientInformation(int  RecordID,int patientID,int  DecoderID,int RecordDate,String  Description){
       this.DecoderID=RecordID;
       this.patientID=patientID;
       this.DecoderID=DecoderID;
       this.RecordDate=RecordDate;
       this.Description=Description;
    
    }

    public int getRecordID() {
        return RecordID;
    }

    public int getPatientID() {
        return patientID;
    }

    public int getDecoderID() {
        return DecoderID;
    }

    public int getRecordDate() {
        return RecordDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setRecordID(int RecordID) {
        this.RecordID = RecordID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setDecoderID(int DecoderID) {
        this.DecoderID = DecoderID;
    }

    public void setRecordDate(int RecordDate) {
        this.RecordDate = RecordDate;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
   
    
    
}
