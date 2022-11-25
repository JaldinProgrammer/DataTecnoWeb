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
public class disease_symptom {
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
            int id_disease,
            int id_symptom
    ) throws SQLException {

        try {
            String query = "INSERT INTO disease_symptoms "
                    + "(id_disease,id_symptom)"
                    + "values(?, ?)";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, id_disease);
            ps.setInt(2, id_symptom);
            if (ps.executeUpdate() == 0) {
                System.out.println("Error creating disease_symptom, review the disease and symptom id exists"); 
                throw new SQLException();
            }
            return "disease_symptom created with success";
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    }
    
    public List<String[]> display() throws SQLException {
        List<String[]> rows = new ArrayList<>();

        String query = "SELECT * FROM disease_symptoms";

        PreparedStatement ps = DB.connect().prepareStatement(query);

        ResultSet set = ps.executeQuery();

        while (set.next()) {
            rows.add(new String[]{
                String.valueOf(set.getInt("id_disease")),
                set.getString("id_symptom"),});
        }
        return rows;
    }
    
     public String delete( int id_disease, int id_symptom) throws SQLException{
        
        try{
            String query = "DELETE FROM disease_symptoms WHERE id_disease = ? and id_symptom = ?";

            PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, id_disease);
            ps.setInt(2, id_symptom);

            if (ps.executeUpdate() == 0) {
                System.out.println("Error deleting Disease symptom row");
                throw new SQLException();
            }
            return "disease symptom row deleted correctly";
        }catch(Exception e){
            System.out.println(e);
            return e.toString();
        }
    }
     
    
    public String update(int id_disease, int id_symptom,int newid_disease, int newid_symptom ) throws SQLException{
        
        try{
            String query = "UPDATE disease_symptoms SET id_disease=?, id_symptom=?"
                    +"WHERE id_disease=? and id_symptom=?";

             PreparedStatement ps = DB.connect().prepareStatement(query);

            ps.setInt(1, newid_disease);
            ps.setInt(2, newid_symptom);
            ps.setInt(3, id_disease);
            ps.setInt(4, id_symptom);

            if (ps.executeUpdate() == 0) {
                System.out.println("Class DUsuario.java dice: Error al MODIFICAR Disease_symptoms");
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
