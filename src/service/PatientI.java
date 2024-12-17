package service;

import pojo.Patient;

import java.util.ArrayList;

public interface PatientI {
    void regiter(Patient p);
    public boolean IsRegisted(Patient p);
    public boolean updateDetails(Patient p);
    public boolean deleteEntry(Patient p);

    public void viewData();

    public ArrayList<Patient> fetchPatientData() throws Exception ;


}
