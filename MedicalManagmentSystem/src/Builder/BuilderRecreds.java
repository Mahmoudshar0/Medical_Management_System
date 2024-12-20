package Builder;

public class BuilderRecreds {
     private int RecordID;
    private int patientID;
    private int DecoterID;
    private int RecordDate;
    private String Description;
    public BuilderRecreds set_RecordID(int RecordID){
    this.RecordID=RecordID;
    return this;
    }
    public BuilderRecreds set_patientID(int  patientID){
    this. patientID= patientID;
    return this;
    }
    public BuilderRecreds set_DecoterID(int decortID){
    this.DecoterID=decortID;
    return this;
    }
    
     public BuilderRecreds set_RecordDate(int RecordDate){
    this.RecordDate=RecordDate;
    return this;
    }
    public BuilderRecreds set_Descriptionint (String Description){
    this.Description=Description;
    return this;
    }
    public patientInformation buildd(){
        return new patientInformation ( RecordID,patientID,DecoterID,RecordDate,Description);
    }  
}
