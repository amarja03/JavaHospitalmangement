package service;

import daolayer.DAO;
import pojo.Patient;

import java.util.ArrayList;

public class PatientServiceImpl implements PatientI {

    @Override
    public void regiter(Patient p) {
        //Patient p1=new Patient(1, "Amit", 43, "male");
        DAO.insertPatientD(p);
    }

    @Override
    public  boolean IsRegisted(Patient p) {

        boolean b= DAO.checkId(p.getPid());
        return b;
    }

    @Override
    public boolean updateDetails(Patient p) {
        // TODO Auto-generated method stub
        boolean bb= DAO.updateDetails(p.getPid(),p.getName(),p.getAge(),p.getGender());
        return bb;
    }

    @Override
    public boolean deleteEntry(Patient p) {
        return DAO.deleteEntry(p);
    }


    @Override
    public void viewData() {
        // TODO Auto-generated method stub

    }

    @Override
    public ArrayList<Patient > fetchPatientData() throws Exception {
        return DAO.fetchPatientData();
    }

}
