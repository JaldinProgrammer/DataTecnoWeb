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
 * @author carlos.jaldin
 */
public class User {

    private final SqlConnection DB = new SqlConnection(
            "grupo20sc",
            "grup020grup020",
            "mail.tecnoweb.org.bo",
            "5432",
            "db_grupo20sc"
    );
    public static final String[] HEADERS
            = {"CI", "CELLPHONE", "EMAIL", "FULLNAME","ISDOCTOR", "GENRE"};
    // create, update, delete devuelven string
    // show, display  Array<String>
    public String create(
            int ci,
            String cellphone,
            String email,
            String fullname,
            String genre,
            String isdoctor
    ) throws SQLException {

        try {
            String query = "INSERT INTO users "
                    + "(ci, cellphone, email, fullname, gender, isdoctor)"
                    + "values(?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, ci);
            ps.setString(2, cellphone);
            ps.setString(3, email);
            ps.setString(4, fullname);
            ps.setString(5, genre);
            ps.setBoolean(6, (isdoctor.equalsIgnoreCase("True")));
            if (ps.executeUpdate() == 0) {
                System.out.println("Error creating user"); 
                throw new SQLException();
            }
            return "User created with success";
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    }

    public List<String[]> display() throws SQLException {
        List<String[]> rows = new ArrayList<>();

        String query = "SELECT * FROM users";

        PreparedStatement ps = DB.connect().prepareStatement(query);

        ResultSet set = ps.executeQuery();

        while (set.next()) {
            rows.add(new String[]{
                String.valueOf(set.getInt("ci")),
                set.getString("cellphone"),
                set.getString("email"),
                set.getString("fullname"),
                set.getString("isdoctor"),
                set.getString("gender"),});
        }
        return rows;
    }
    
    public String delete( String ci) throws SQLException{
        
        try{
            String query = "DELETE FROM users WHERE ci = ?";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, ci);

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
    
    public String update(int id, String nombre,String correo,String contrasena,String rol) throws SQLException{
        
        try{
            String query = "UPDATE usuarios SET nombre=?, correo=?, contrasena=?, rol=?"
                    +"WHERE id = ?";

             PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setString(3, contrasena);
            ps.setString(4, rol);
            ps.setInt(5, id);

            if (ps.executeUpdate() == 0) {
                System.out.println("Class DUsuario.java dice: Error al MODIFICAR usuario");
                throw new SQLException();
            }    
            return "user updated correctly";
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
