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
import postgresqlconnection.SqlConnection;

/**
 *
 * @author VICTUS
 */
public class Diagnostics {
    private final SqlConnection DB = new SqlConnection(
            "grupo20sc",
            "grup020grup020",
            "mail.tecnoweb.org.bo",
            "5432",
            "db_grupo20sc"
    );
    public static final String[] HEADERS
            = {"ID", "DATATIME", "ID_USER", "ID_DISEASE"};
    
        public String update(String id, String datatime,String id_user,String id_disease) throws SQLException{
        
        try{
            String query = "UPDATE diagnostics SET datatime=?, id_user=?, id_disease=?"
                    +"WHERE id = ?";

             PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, datatime);
            ps.setString(2, id_user);
            ps.setString(3, id_disease);
            ps.setString(4, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Class Diagnostics.java dice: Error al MODIFICAR Diagnostics");
                throw new SQLException();
            }    
            return "Diagnostics updated correctly";
        }catch(Exception e){
            System.out.println(e);
            return e.toString();
        }
        
    }


    public List<String[]> display(int id) throws SQLException {
        List<String[]> rows = new ArrayList<>();

        String query = "SELECT * FROM diagnostics WHERE id = ?";

        PreparedStatement ps = DB.connect().prepareStatement(query);
        
        ps.setInt(1, id);
        
        ResultSet set = ps.executeQuery();

        while (set.next()) {
            rows.add(new String[]{
                set.getString("id"),
                set.getString("datatime"),
                set.getString("id_user"),
                set.getString("id_disease"),});
        }
        return rows;
    }
    
    public String delete( String id) throws SQLException{
        
        try{
            String query = "DELETE FROM diagnostics WHERE id = ?";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Error deleting diagnostics");
                throw new SQLException();
            }
            return "diagnostics deleted correctly";
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

    public String create(
            String datatime,
            String id_user,
            String id_disease) 
    throws SQLException {
        try {
            String query = "INSERT INTO Diagnostics "
                    + "(datatime, id_user, id_disease)"
                    + "values(?, ?, ?)";

            PreparedStatement ps = DB.connect().prepareStatement(query);
            
            ps.setString(1, datatime);
            ps.setString(2, id_user);
            ps.setString(3, id_disease);
            if (ps.executeUpdate() == 0) {
                System.out.println("Error creating Diagnostics"); 
                throw new SQLException();
            }
            return "Diagnostics created with success";
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    }
}
