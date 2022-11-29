/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.Promotions;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VICTUS
 */
public class PromotionsBusiness {
    private Promotions promotions;
    
    public PromotionsBusiness(){
        this.promotions = new Promotions();
    }
    
    public String create(List<String> params) throws SQLException{
        
        String res = promotions.create(
                Integer.parseInt(params.get(0)), 
                params.get(1),
                params.get(2)
        );
        
        promotions.disconnect();
        return res;
    }
    
    public ArrayList<String[]> display() throws SQLException {
        ArrayList<String[]> promotiones = (ArrayList<String[]>) promotions.display();
        promotions.disconnect();
        return promotiones;
    }
    
    public String delete(int id) throws SQLException{
        
        String res = promotions.delete(id);
        
        promotions.disconnect();
        return res;
    }
    
     public String update(List<String> params) throws SQLException{
        
        String res = promotions.update(
                Integer.parseInt(params.get(0)), 
                params.get(1),
                params.get(2)
                 
        );
        
        promotions.disconnect();
        return res;
    }
}
