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
public class Specialties {
    
      private final SqlConnection DB = new SqlConnection(
            "grupo20sc",
            "grup020grup020",
            "mail.tecnoweb.org.bo",
            "5432",
            "db_grupo20sc"
    );
    public static final String[] HEADERS
            = {"ID", "NAME"};
    //create, update, delete
    //show, display
    
    public String create(
    int id,
    String name
    ) throws SQLException{
         try {
            String query = "INSERT INTO specialties "
                    + "(id, name)"
                    + "values(?, ?)";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
           
            if (ps.executeUpdate() == 0) {
                System.out.println("Error creating speciality"); 
                throw new SQLException();
            }
            return "speciality created with success";
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    } 
    
    public List<String[]> display() throws SQLException {
        List<String[]> rows = new ArrayList<>();

        String query = "SELECT * FROM specialties";

        PreparedStatement ps = DB.connect().prepareStatement(query);

        ResultSet set = ps.executeQuery();

        while (set.next()) {
            rows.add(new String[]{
                String.valueOf(set.getInt("id")),
                set.getString("name"),});
        }
        return rows;
    }
    
     public String delete(int id) throws SQLException{
        
        try{
            String query = "DELETE FROM specialties WHERE id = ?";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Error deleting speciality");
                throw new SQLException();
            }
            return "speciality deleted correctly note that all values dependent on this specialty willalso be deleted";
        }catch(Exception e){
            System.out.println(e);
            return e.toString();
        }
    }
     
     public String update(int id, String name) throws SQLException{
        
        try{
            String query = "UPDATE specialties SET name=?" //in users it was as name, why? if in the db is as fullname
                    +"WHERE id = ?";

             PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Class DUsuario.java dice: Error al MODIFICAR Especialidad");
                throw new SQLException();
            }    
            return "speciality updated correctly";
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
