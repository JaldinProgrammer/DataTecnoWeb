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
public class History {
     private final SqlConnection DB = new SqlConnection(
            "grupo20sc",
            "grup020grup020",
            "mail.tecnoweb.org.bo",
            "5432",
            "db_grupo20sc"
    );
    public static final String[] HEADERS
            = {"ID", "DATATIME", "ID_USER", "ID_DISEASE"};


    public List<String[]> display(String id_user) throws SQLException {
        List<String[]> rows = new ArrayList<>();

        String query = "SELECT * FROM diagnostics WHERE id_user = ?";

        PreparedStatement ps = DB.connect().prepareStatement(query);
        
        ps.setString(1, id_user);
        
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
    

    public void disconnect() {
        if (DB != null) {
            DB.closeConnection();
        }
    }


}
