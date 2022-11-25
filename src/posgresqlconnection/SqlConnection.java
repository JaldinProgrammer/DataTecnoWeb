/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package posgresqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author franz
 */


public class SqlConnection {
    private static final String DRIVER = "jdbc:postgresql://";
    
    private Connection connection;
    private String user;
    private String password;
    private String host;
    private String port;
    private String namedb;
    private String url;

    public SqlConnection(String user, String password, String host, String port, String namedb) {
        this.user = user;
        this.password = password;
        this.host = host;
        this.port = port;
        this.namedb = namedb;
        
        this.url = DRIVER + host + ":" + port + "/" + namedb; //127.0.0.1:5432
    }

    public Connection connect(){
        try {
             connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Class SqlConnection.java: error al conectar con la DB ");
        }
        return connection;
    }
    
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
             System.out.println("Class SqlConnection.java: error al cerrar la conexion ");
        }
    }
    
}
