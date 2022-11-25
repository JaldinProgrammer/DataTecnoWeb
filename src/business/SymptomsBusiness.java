/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.Symptoms;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author franz
 */
public class SymptomsBusiness {
     private Symptoms symptoms;
    
    public SymptomsBusiness(){
        this.symptoms = new Symptoms();
    }
    
    public String create(List<String> params) throws SQLException{
        
        String res = symptoms.create(
                Integer.parseInt(params.get(0)), 
                params.get(1)   
        );
        
        symptoms.disconnect();
        return res;
    }
    
     public ArrayList<String[]> display() throws SQLException {
        ArrayList<String[]> sintomas = (ArrayList<String[]>) symptoms.display();
        symptoms.disconnect();
        return sintomas;
    }
    
    public String delete(int id) throws SQLException{
        
        String res = symptoms.delete(id);
        
        symptoms.disconnect();
        return res;
    }
    
     public String update(List<String> params) throws SQLException{
        
        String res = symptoms.update(
                Integer.parseInt(params.get(0)), 
                params.get(1)   
        );
        
        symptoms.disconnect();
        return res;
    }
}
