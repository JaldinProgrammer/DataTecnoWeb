/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.Diseases;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franz
 */
public class DiseasesBusiness {
    private Diseases diseases;
    
    public DiseasesBusiness(){
        this.diseases = new Diseases();
    }
    
    public String create(List<String> params) throws SQLException{
        
        String res = diseases.create(
                Integer.parseInt(params.get(0)), 
                params.get(1),
                params.get(2)
        );
        
        diseases.disconnect();
        return res;
    }
    
     public ArrayList<String[]> display() throws SQLException {
        ArrayList<String[]> enfermedades = (ArrayList<String[]>) diseases.display();
        diseases.disconnect();
        return enfermedades;
    }
    
    public String delete(int id) throws SQLException{
        
        String res = diseases.delete(id);
        
        diseases.disconnect();
        return res;
    }
    
     public String update(List<String> params) throws SQLException{
        
        String res = diseases.update(
                Integer.parseInt(params.get(0)), 
                params.get(1),
                params.get(2)
        );
        
        diseases.disconnect();
        return res;
    }
}
