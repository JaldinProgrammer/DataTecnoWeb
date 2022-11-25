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
public class Symptoms {
    
      private final SqlConnection DB = new SqlConnection(
            "grupo20sc",
            "grup020grup020",
            "mail.tecnoweb.org.bo",
            "5432",
            "db_grupo20sc"
    );
    public static final String[] HEADERS
            = {"ID", "DESCRIPTION"};
    // create, update, delete devuelven string
    // show, display  Array<String>
    public String create(
            int id,
            String description
           
    ) throws SQLException {

        try {
            String query = "INSERT INTO symptoms "
                    + "(id, description)"
                    + "values(?, ?)";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, description);
            if (ps.executeUpdate() == 0) {
                System.out.println("Error creating symptom"); 
                throw new SQLException();
            }
            return "symptom created with success";
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    }

    public List<String[]> display() throws SQLException {
        List<String[]> rows = new ArrayList<>();

        String query = "SELECT * FROM symptoms";

        PreparedStatement ps = DB.connect().prepareStatement(query);

        ResultSet set = ps.executeQuery();

        while (set.next()) {
            rows.add(new String[]{
                String.valueOf(set.getInt("id")),
                set.getString("description"),
            });
        }
        return rows;
    }
    
    public String delete( int id) throws SQLException{
        
        try{
            String query = "DELETE FROM symptoms WHERE id = ?";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Error deleting symptom");
                throw new SQLException();
            }
            return "symptom deleted correctly";
        }catch(Exception e){
            System.out.println(e);
            return e.toString();
        }
    }
    
    public String update(int id, String description) throws SQLException{
        
        try{
            String query = "UPDATE symptoms SET description=?"
                    +"WHERE id = ?";

             PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, description);
            ps.setInt(2, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Class DUsuario.java dice: Error al MODIFICAR symptom");
                throw new SQLException();
            }    
            return "symptom updated correctly";
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
