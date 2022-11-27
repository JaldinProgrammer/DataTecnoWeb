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
public class Promotions {
    private final SqlConnection DB = new SqlConnection(
            "grupo20sc",
            "grup020grup020",
            "mail.tecnoweb.org.bo",
            "5432",
            "db_grupo20sc"
    );
    public static final String[] HEADERS
            = {"ID", "TITLE", "DESCRIPTION"};
    // create, update, delete devuelven string
    // show, display  Array<String>
    public String create(
            String title,
            String description
    ) throws SQLException {

        try {
            String query = "INSERT INTO promotions "
                    + "(title, description)"
                    + "values(?, ?)";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, title);
            ps.setString(2, description);
            if (ps.executeUpdate() == 0) {
                System.out.println("Error creating promotions"); 
                throw new SQLException();
            }
            return "promotions created with success";
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    }

    public List<String[]> display() throws SQLException {
        List<String[]> rows = new ArrayList<>();

        String query = "SELECT * FROM promotions";

        PreparedStatement ps = DB.connect().prepareStatement(query);

        ResultSet set = ps.executeQuery();

        while (set.next()) {
            rows.add(new String[]{
                set.getString("id"),
                set.getString("title"),
                set.getString("description"),});
        }
        return rows;
    }
    
    public String delete( String id) throws SQLException{
        
        try{
            String query = "DELETE FROM promotions WHERE id = ?";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Error deleting promotions");
                throw new SQLException();
            }
            return "promotions deleted correctly";
        }catch(Exception e){
            System.out.println(e);
            return e.toString();
        }
    }
    
    public String update(String id, String title,String description) throws SQLException{
        
        try{
            String query = "UPDATE promotions SET title=?, description=?"
                    +"WHERE id = ?";

             PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, title);
            ps.setString(2, description);
            ps.setString(5, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Class Dpromotions.java dice: Error al MODIFICAR promotions");
                throw new SQLException();
            }    
            return "promotions updated correctly";
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
