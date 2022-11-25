/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.disease_symptom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author franz
 */
public class Disease_symptomsBusiness {
     private disease_symptom dsymptom;
    
    public Disease_symptomsBusiness(){
        this.dsymptom = new disease_symptom();
    }
    
    public String create(List<String> params) throws SQLException{
        
        String res = dsymptom.create(
                Integer.parseInt(params.get(0)), 
                Integer.parseInt(params.get(1))
        );
        
        dsymptom.disconnect();
        return res;
    }
    
     public ArrayList<String[]> display() throws SQLException {
        ArrayList<String[]> sintomas_enfermedad = (ArrayList<String[]>) dsymptom.display();
        dsymptom.disconnect();
        return sintomas_enfermedad;
    }
    
    public String delete(int id_disease, int id_symptom) throws SQLException{
        
        String res = dsymptom.delete(id_disease,id_symptom);
        
        dsymptom.disconnect();
        return res;
    }
    
    
    public String update(List<String> params) throws SQLException{
        
        String res = dsymptom.update(
                Integer.parseInt(params.get(0)), 
                Integer.parseInt(params.get(1)),
                Integer.parseInt(params.get(2)), 
                Integer.parseInt(params.get(3))
                 
        );
        
        dsymptom.disconnect();
        return res;
     }
}
