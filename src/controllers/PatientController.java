package controllers;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

import daolayer.DAO;
import pojo.Patient;
import service.PatientServiceImpl;

public class PatientController {
    public static void main(String[] args) {
        PatientServiceImpl pp = new PatientServiceImpl();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice:");
        System.out.println("1: Register Patient");
        System.out.println("2: Check if Patient is Registered");
        System.out.println("3: Fetch All Patients");
        System.out.println("4: Update Patient Details");
        System.out.println("5: Delete Patient Record");
        System.out.println("6: Exit");

        int n=sc.nextInt();
        do
        {
            switch (n) {
                case 1:

                    System.out.println("Enter Patients id,name,age,gender");
                    Patient p = new Patient(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    pp.regiter(p);
                    break;
                case 2:
                    System.out.println("Enter Patients id");
                    Patient p1 = new Patient(sc.nextInt());
                    if(pp.IsRegisted(p1)){
                        System.out.println("Patient already exits");
                    }else{
                        System.out.println("***Please Register Patients Details***");
                        System.out.println("Enter id , name age , gender");
                        Patient namePatient= new Patient(sc.nextInt(),sc.next(),sc.nextInt(),sc.next());
                        pp.regiter(namePatient);
                    }break;
                case 3:
                    try {
                        ArrayList<Patient> al=pp.fetchPatientData();
                        for(Patient patient : al){
                            System.out.println(patient);
                        }
                    } catch (Exception e) {

                    }
                    break;
                case 4:
                    System.out.println("enter details to update");
                    Patient p3=new Patient(sc.nextInt(),sc.next(),sc.nextInt(),sc.next());
                    if (pp.updateDetails(p3)) {
                        System.out.println("Enter new id,name, age, and gender:");
                        int id=sc.nextInt();
                        String name = sc.next();
                        int age = sc.nextInt();
                        String gender = sc.next();

                    } else {
                        System.out.println("Patient not found. Please register first.");
                    }
                    break;

                case 5:
                    System.out.println("Enter id you want to delete");
                    Patient p4 = new Patient(sc.nextInt());
                    pp.deleteEntry(p4);
                    break;
                case 6:
                    System.out.println("Enter id to view data");
                    Patient p5=new Patient(sc.nextInt());
                    pp.viewData();
            }
        }while(n!=5);

    }
}
