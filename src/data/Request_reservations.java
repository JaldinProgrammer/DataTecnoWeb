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
import java.util.Date;
import postgresqlconnection.SqlConnection;

/**
 *
 * @author VICTUS
 */
public class Request_reservations {
    private final SqlConnection DB = new SqlConnection(
            "grupo20sc",
            "grup020grup020",
            "mail.tecnoweb.org.bo",
            "5432",
            "db_grupo20sc"
    );
    public static final String[] HEADERS
            = {"ID", "DATETIME", "DESCRIPTION", "START_TIME","END_TIME", "ID_USER"};
    // create, update, delete devuelven string
    // show, display  Array<String>
    public String create(
            int id,
            String datetime,
            String description,
            String start_time,
            String end_time,
            int id_user
    ) throws SQLException {

        try {
            String query = "INSERT INTO request_reservations "
                    + "(id, datetime, description, start_time, end_time, id_user)"
                    + "values(?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, id);
             ps.setString(3, datetime);
            ps.setString(3, description);
            ps.setString(4, start_time);
            ps.setString(5, end_time);
            ps.setInt(6, id_user);
            if (ps.executeUpdate() == 0) {
                System.out.println("Error creating request_reservations"); 
                throw new SQLException();
            }
            return "request_reservations created with success";
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    }

    public List<String[]> display() throws SQLException {
        List<String[]> rows = new ArrayList<>();

        String query = "SELECT * FROM request_reservations";

        PreparedStatement ps = DB.connect().prepareStatement(query);

        ResultSet set = ps.executeQuery();

        while (set.next()) {
            rows.add(new String[]{
                set.getString("id"),
                set.getString("date"),
                set.getString("description"),
                set.getString("start_time"),
                set.getString("end_time"),
                set.getString("id_user"),});
        }
        return rows;
    }
    
    public String delete( String id) throws SQLException{
        
        try{
            String query = "DELETE FROM request_reservations WHERE id = ?";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Error deleting request_reservations");
                throw new SQLException();
            }
            return "request_reservations deleted correctly";
        }catch(Exception e){
            System.out.println(e);
            return e.toString();
        }
    }
    
    public String update(String id, String date,String description,String start_time,String end_time, String id_user) throws SQLException{
        
        try{
            String query = "UPDATE request_reservations SET date=?, description=?, start_time=?, end_time=?, id_user=?"
                    +"WHERE id = ?";

             PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, date);
            ps.setString(2, description);
            ps.setString(3, start_time);
            ps.setString(4, end_time);
            ps.setString(5, id_user);
            ps.setString(6, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Class Drequest_reservations.java dice: Error al MODIFICAR request_reservations");
                throw new SQLException();
            }    
            return "request_reservations updated correctly";
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
