/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.Diagnostic_symptom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VICTUS
 */
public class Diagnostic_symptomBusiness {
    private Diagnostic_symptom dsymptoms;
    
    public Diagnostic_symptomBusiness(){
        this.dsymptoms = new Diagnostic_symptom();
    }
    
    public String create(List<String> params) throws SQLException{
        
        String res = dsymptoms.create(
               Integer.parseInt(params.get(0)), 
                Integer.parseInt(params.get(1)) 
        );
        
        dsymptoms.disconnect();
        return res;
    }
    
     public ArrayList<String[]> display() throws SQLException {
        ArrayList<String[]> diagnostic_symptom = (ArrayList<String[]>) dsymptoms.display();
        dsymptoms.disconnect();
        return diagnostic_symptom;
    }
    
    public String delete(int id_diagnostic, int id_symptom) throws SQLException{
        
        String res = dsymptoms.delete(id_diagnostic,id_symptom);
        
        dsymptoms.disconnect();
        return res;
    }
    
     public String update(List<String> params) throws SQLException{
        
        String res = dsymptoms.update(
                Integer.parseInt(params.get(0)), 
                Integer.parseInt(params.get(1)),
                Integer.parseInt(params.get(2)), 
                Integer.parseInt(params.get(3))
                 
        );
        
        dsymptoms.disconnect();
        return res;
    }
}
