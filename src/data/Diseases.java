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
public class Diseases {
      private final SqlConnection DB = new SqlConnection(
            "grupo20sc",
            "grup020grup020",
            "mail.tecnoweb.org.bo",
            "5432",
            "db_grupo20sc"
    );
    public static final String[] HEADERS
            = {"ID", "NAME", "NAME_SPECIFIC"};
    // create, update, delete devuelven string
    // show, display  Array<String>
    public String create(
            int id,
            String name,
            String name_specific
    ) throws SQLException {

        try {
            String query = "INSERT INTO diseases "
                    + "(id, name, name_specific)"
                    + "values(?, ?, ?)";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, name_specific);
            if (ps.executeUpdate() == 0) {
                System.out.println("Error creating disease"); 
                throw new SQLException();
            }
            return "disease created with success";
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    }

    public List<String[]> display() throws SQLException {
        List<String[]> rows = new ArrayList<>();

        String query = "SELECT * FROM diseases";

        PreparedStatement ps = DB.connect().prepareStatement(query);

        ResultSet set = ps.executeQuery();

        while (set.next()) {
            rows.add(new String[]{
                String.valueOf(set.getInt("id")),
                set.getString("name"),
                set.getString("name_specific"),
            });
        }
        return rows;
    }
    
    public String delete( int id) throws SQLException{
        
        try{
            String query = "DELETE FROM diseases WHERE id = ?";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Error deleting disease");
                throw new SQLException();
            }
            return "disease deleted correctly";
        }catch(Exception e){
            System.out.println(e);
            return e.toString();
        }
    }
    
    public String update(int id, String name,String name_specific) throws SQLException{
        
        try{
            String query = "UPDATE diseases SET name=?, name_specific=?"
                    +"WHERE id = ?";

             PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, name_specific);
            ps.setInt(3, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Class DUsuario.java dice: Error al MODIFICAR diseases");
                throw new SQLException();
            }    
            return "disease updated correctly";
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
