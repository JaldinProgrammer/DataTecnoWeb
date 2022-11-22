/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import posgresqlconnection.SqlConnection;

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
            = {"ID", "STARTDATE", "EMAIL", "FULLNAME","GENRE", "ISDOCTOR"};
    
    
}
