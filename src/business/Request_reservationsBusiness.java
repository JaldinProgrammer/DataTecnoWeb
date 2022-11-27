/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.Request_reservations;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VICTUS
 */
public class Request_reservationsBusiness {
    private Request_reservations Rreservation;
    
    public Request_reservationsBusiness(){
        this.Rreservation = new Request_reservations();
    }
    
    public String create(List<String> params) throws SQLException{
        
        String res = Rreservation.create(
                params.get(0),
                params.get(1), 
                params.get(2), 
                params.get(3), 
                params.get(4), 
                params.get(5)
        );
        
        Rreservation.disconnect();
        return res;
    }
    
     public ArrayList<String[]> display() throws SQLException {
        ArrayList<String[]> reservatione = (ArrayList<String[]>) Rreservation.display();
        Rreservation.disconnect();
        return reservatione;
    }
    
    public String delete(String id) throws SQLException{
        
        String res = Rreservation.delete(id);
        
        Rreservation.disconnect();
        return res;
    }
    
     public String update(List<String> params) throws SQLException{
        
        String res = Rreservation.update(
                params.get(0), 
                params.get(1),
                params.get(2), 
                params.get(3),
                params.get(4),
                params.get(5)
                 
        );
        
        Rreservation.disconnect();
        return res;
    }
}
