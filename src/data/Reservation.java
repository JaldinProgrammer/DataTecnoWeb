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
 * @author carlos.jaldin
 */
public class Reservation {
     private final SqlConnection DB = new SqlConnection(
            "grupo20sc",
            "grup020grup020",
            "mail.tecnoweb.org.bo",
            "5432",
            "db_grupo20sc"
    );
    public static final String[] HEADERS
            = {"ID", "DATE", "DESCRIPTION", "START_TIME","END_TIME", "ID_USER", "ID_REQUESTR", "ID_DIAGNOSTIC"};
    // create, update, delete devuelven string
    // show, display  Array<String>
    public String create(
            String id,
            String date,
            String description,
            String start_time,
            String end_time,
            String id_user,
            String id_requestR,
            String id_diagnostic
    ) throws SQLException {

        try {
            String query = "INSERT INTO reservations "
                    + "(id, date, description, start_time, end_time, id_user, id_requestR, id_diagnostic)"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, id);
            ps.setString(2, date);
            ps.setString(3, description);
            ps.setString(4, start_time);
            ps.setString(5, end_time);
            ps.setString(6, id_user);
            ps.setString(7, id_requestR);
            ps.setString(8, id_diagnostic);
            if (ps.executeUpdate() == 0) {
                System.out.println("Error creating reservations"); 
                throw new SQLException();
            }
            return "reservations created with success";
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    }

    public List<String[]> display() throws SQLException {
        List<String[]> rows = new ArrayList<>();

        String query = "SELECT * FROM reservations";

        PreparedStatement ps = DB.connect().prepareStatement(query);

        ResultSet set = ps.executeQuery();

        while (set.next()) {
            rows.add(new String[]{
                set.getString("id"),
                set.getString("date"),
                set.getString("description"),
                set.getString("start_time"),
                set.getString("end_time"),
                set.getString("id_user"),
                set.getString("id_requestR"),
                set.getString("id_diagnostic"),});
        }
        return rows;
    }
    
    public String delete( String id) throws SQLException{
        
        try{
            String query = "DELETE FROM reservations WHERE id = ?";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Error deleting reservations");
                throw new SQLException();
            }
            return "reservations deleted correctly";
        }catch(Exception e){
            System.out.println(e);
            return e.toString();
        }
    }
    
    public String update(String id, String date,String description,String start_time,String end_time, String id_user,  String id_requestR, String id_diagnostic) throws SQLException{
        
//        set.getString("id"),
//                set.getString("date"),
//                set.getString("description"),
//                set.getString("start_time"),
//                set.getString("end_time"),
//                set.getString("id_user"),
//                set.getString("id_requestR"),
//                set.getString("id_diagnostic"),});
        
        try{
            String query = "UPDATE reservations SET date=?, description=?, start_time=?, end_time=?, id_user=?, id_requestR=?, id_diagnostic=?"
                    +"WHERE id = ?";

             PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, date);
            ps.setString(2, description);
            ps.setString(3, start_time);
            ps.setString(4, end_time);
            ps.setString(5, id_user);
            ps.setString(6, id_requestR);
            ps.setString(7, id_diagnostic);
            ps.setString(8, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Class Dreservations.java dice: Error al MODIFICAR reservations");
                throw new SQLException();
            }    
            return "reservations updated correctly";
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
