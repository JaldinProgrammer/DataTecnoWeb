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
public class Diagnostic_symptom {
     private final SqlConnection DB = new SqlConnection(
            "grupo20sc",
            "grup020grup020",
            "mail.tecnoweb.org.bo",
            "5432",
            "db_grupo20sc"
    );
    public static final String[] HEADERS
                = {"ID_DIAGNOSTIC", "ID_SYMPTOM"};
    // create, update, delete devuelven string
    // show, display  Array<String>
    public String create(
            int id_diagnostic,
            int id_symptom
    ) throws SQLException {

        try {
            String query = "INSERT INTO diagnostic_symptoms "
                    + "(id_diagnostic, id_symptom)"
                    + "values(?, ?)";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, id_diagnostic);
            ps.setInt(2, id_symptom);
            if (ps.executeUpdate() == 0) {
                System.out.println("Error creating diagnostic_symptoms"); 
                throw new SQLException();
            }
            return "diagnostic_symptoms created with success";
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    }

    public List<String[]> display() throws SQLException {
        List<String[]> rows = new ArrayList<>();

        String query = "SELECT * FROM diagnostic_symptoms";

        PreparedStatement ps = DB.connect().prepareStatement(query);

        ResultSet set = ps.executeQuery();

        while (set.next()) {
            rows.add(new String[]{
                set.getString("id_diagnostic"),
                set.getString("id_symptom"),});
        }
        return rows;
    }
    
    public String delete( int id_diagnostic, int id_symptom) throws SQLException{
        
        try{
            String query = "DELETE FROM diagnostic_symptoms WHERE id_diagnostic = ? and id_symptom= ? ";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, id_diagnostic);
            ps.setInt(2, id_symptom);

            if (ps.executeUpdate() == 0) {
                System.out.println("Error deleting user");
                throw new SQLException();
            }
            return "user deleted correctly";
        }catch(Exception e){
            System.out.println(e);
            return e.toString();
        }
    }
    
    public String update(int id_diagnostic, int id_symptom,int newid_diagnostic, int newid_symptom ) throws SQLException{
        
        try{
            String query = "UPDATE diagnostic_symptoms SET id_diagnostic=?, id_symptom=?"
                    +"WHERE id_diagnostic=? and id_symptom=?";

             PreparedStatement ps = DB.connect().prepareStatement(query);

             ps.setInt(1, newid_diagnostic);
            ps.setInt(2, newid_symptom);
            ps.setInt(3, id_diagnostic);
            ps.setInt(4, id_symptom);

            if (ps.executeUpdate() == 0) {
                System.out.println("Class DUsuario.java dice: Error al MODIFICAR usuario");
                throw new SQLException();
            }    
            return "diagnostic_symptoms updated correctly";
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
