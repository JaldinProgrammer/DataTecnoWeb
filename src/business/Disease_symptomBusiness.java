/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.Disease_symptom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VICTUS
 */
public class Disease_symptomBusiness {
    private Disease_symptom ddsymptoms;
    
    public Disease_symptomBusiness(){
        this.ddsymptoms = new Disease_symptom();
    }
    
    public String create(List<String> params) throws SQLException{
        
        String res = ddsymptoms.create(
                params.get(0), 
                params.get(1)
        );
        
        ddsymptoms.disconnect();
        return res;
    }
    
     public ArrayList<String[]> display() throws SQLException {
        ArrayList<String[]> diagnostic_symptom = (ArrayList<String[]>) ddsymptoms.display();
        ddsymptoms.disconnect();
        return diagnostic_symptom;
    }
    
    public String delete(String id_diagnostic, String id_symptom) throws SQLException{
        
        String res = ddsymptoms.delete(id_diagnostic,id_symptom);
        
        ddsymptoms.disconnect();
        return res;
    }
    
     public String update(List<String> params) throws SQLException{
        
        String res = ddsymptoms.update(
                Integer.parseInt(params.get(0)), 
                params.get(1),
                Integer.parseInt(params.get(2)), 
                params.get(3)
                 
        );
        
        ddsymptoms.disconnect();
        return res;
    }
}
