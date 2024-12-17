package daolayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Patient;

public class DAO {
    private static final String url="jdbc:mysql://localhost:3306/hospitalmanagement";
    private static final String username="root";
    private static final String password="test123";
    public static Connection con=null;
    public static PreparedStatement pstmt=null;
    public static Connection getDbConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void insertPatientD(Patient p)
    {
        String SQL="Insert into patient values(?,?,?,?)";
        try {

            pstmt=getDbConnection().prepareStatement(SQL);
            pstmt.setInt(1,p.getPid());
            pstmt.setString(2,p.getName());
            pstmt.setInt(3,p.getAge());
            pstmt.setString(4,p.getGender());
            pstmt.executeUpdate();
            System.out.println("Data inserted Successfully");
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    public static boolean checkId(int pid)
    {
        String SQL="select *from patient where pid=?";
        boolean status=false;
        try {
            pstmt=getDbConnection().prepareStatement(SQL);
            pstmt.setInt(1, pid);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {
                status= true;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return status;
    }
    public static ArrayList<Patient> fetchPatientData() {
        String SQL="select *from patient ";
        ArrayList<Patient> arrpatient=new ArrayList<>();
        try {
            pstmt=getDbConnection().prepareStatement(SQL);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {
               int id=rs.getInt(1);
               String name=rs.getString(2);
               int age=rs.getInt(3);
               String gender=rs.getString(4);
               arrpatient.add(new Patient(id,name,age,gender));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return arrpatient;
    }

    public static boolean updateDetails(int pid, String name, int age, String gender) {
        String SQL = "UPDATE patient SET name=?, age=?, gender=? WHERE pid=?";
        try {
            pstmt = getDbConnection().prepareStatement(SQL);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.setInt(4, pid);
            pstmt.executeUpdate();
            System.out.println("Patient details updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean deleteEntry(Patient p)
    {

        String SQL = "DELETE FROM patient WHERE pid=?";
        try {
            pstmt = getDbConnection().prepareStatement(SQL);
            pstmt.setInt(1, p.getPid() );
            pstmt.executeUpdate();
            System.out.println("Patient record deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();

    }

        return false;
    }
}
