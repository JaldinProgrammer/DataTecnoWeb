/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.Reservation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos.jaldin
 */
public class ReservationBusiness {
    private Reservation reservation;
    
    public ReservationBusiness(){
        this.reservation = new Reservation();
    }
    
    public String create(List<String> params) throws SQLException{
        
        String res = reservation.create(
                params.get(0),
                params.get(1), 
                params.get(2), 
                params.get(3), 
                params.get(4), 
                params.get(5), 
                params.get(6), 
                params.get(7)
        );
        
        reservation.disconnect();
        return res;
    }
    
     public ArrayList<String[]> display() throws SQLException {
        ArrayList<String[]> reservatione = (ArrayList<String[]>) reservation.display();
        reservation.disconnect();
        return reservatione;
    }
    
    public String delete(String id) throws SQLException{
        
        String res = reservation.delete(id);
        
        reservation.disconnect();
        return res;
    }
    
     public String update(List<String> params) throws SQLException{
        
        String res = reservation.update(
                params.get(0), 
                params.get(1),
                params.get(2), 
                params.get(3),
                params.get(4),
                params.get(5),
                params.get(6),
                params.get(7)
                 
        );
        
        reservation.disconnect();
        return res;
    }
}
