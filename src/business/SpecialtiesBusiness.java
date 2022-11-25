/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;
import data.Specialties;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author franz
 */
public class SpecialtiesBusiness {
     private Specialties specialties;
    
    public SpecialtiesBusiness(){
        this.specialties = new Specialties();
    }
    
    public String create(List<String> params) throws SQLException{
        
        String res = specialties.create(
                Integer.parseInt(params.get(0)), 
                params.get(1)   
        );
        
        specialties.disconnect();
        return res;
    }
    
     public ArrayList<String[]> display() throws SQLException {
        ArrayList<String[]> especialidades = (ArrayList<String[]>) specialties.display();
        specialties.disconnect();
        return especialidades;
    }
    
    public String delete(int id) throws SQLException{
        
        String res = specialties.delete(id);
        
        specialties.disconnect();
        return res;
    }
    
     public String update(List<String> params) throws SQLException{
        
        String res = specialties.update(
                Integer.parseInt(params.get(0)), 
                params.get(1)   
        );
        
        specialties.disconnect();
        return res;
    }
     
}
