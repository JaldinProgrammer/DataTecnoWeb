/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import posgresqlconnection.SqlConnection;




/**
 *
 * @author franz
 */
public class Doctor_specialties {
    private final SqlConnection DB = new SqlConnection(
            "grupo20sc",
            "grup020grup020",
            "mail.tecnoweb.org.bo",
            "5432",
            "db_grupo20sc"
    );
    public static final String[] HEADERS
            = {"id_specialty", "id_user"};
    //create, update, delete
    //show, display
    
    public String create(
            int id_specialty,
            int id_user
    ) throws SQLException {

        try {
            String query = "INSERT INTO doctor_specialties "
                    + "(id_specialty,id_user)"
                    + "values(?, ?)";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, id_specialty);
            ps.setInt(2, id_user);
            if (ps.executeUpdate() == 0) {
                System.out.println("Error creating specialty, review the user and the specialty id exists"); 
                throw new SQLException();
            }
            return "specialty created with success";
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    }
    
    public List<String[]> display() throws SQLException {
        List<String[]> rows = new ArrayList<>();

        String query = "SELECT * FROM doctor_specialties";

        PreparedStatement ps = DB.connect().prepareStatement(query);

        ResultSet set = ps.executeQuery();

        while (set.next()) {
            rows.add(new String[]{
                String.valueOf(set.getInt("id_specialty")),
                set.getString("id_user"),});
        }
        return rows;
    }
    
     public String delete( int id_specialty, String id_user) throws SQLException{
        
        try{
            String query = "DELETE FROM doctor_specialties WHERE id_specialty = ? and id_user = ?";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, id_specialty);
            ps.setString(2, id_user);

            if (ps.executeUpdate() == 0) {
                System.out.println("Error deleting Doctor_specialties row");
                throw new SQLException();
            }
            return "Doctor_specialties row deleted correctly";
        }catch(Exception e){
            System.out.println(e);
            return e.toString();
        }
    }
     
    
    public String update(int id_specialty, String id_user,int newid_specialty, String newid_user ) throws SQLException{
        
        try{
            String query = "UPDATE doctor_specialties SET id_specialty=?, id_user=?"
                    +"WHERE id_specialty=? and id_user=?";

             PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, newid_specialty);
            ps.setString(2, newid_user);
            ps.setInt(3, id_specialty);
            ps.setString(4, id_user);

            if (ps.executeUpdate() == 0) {
                System.out.println("Class DUsuario.java dice: Error al MODIFICAR Doctor_specialties");
                throw new SQLException();
            }    
            return "doctor_speciaties updated correctly";
        }catch(Exception e){
            System.out.println(e);
            return e.toString();
        }
        
    }

    public void disconnect() {
        if (DB != null) {
            DB.closeConnection();
        }
    }
}
  
