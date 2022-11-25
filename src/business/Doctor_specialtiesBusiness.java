/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.Doctor_specialties;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author franz
 */
public class Doctor_specialtiesBusiness {
    private Doctor_specialties dspecialty;
    
    public Doctor_specialtiesBusiness(){
        this.dspecialty = new Doctor_specialties();
    }
    
    public String create(List<String> params) throws SQLException{
        
        String res = dspecialty.create(
                Integer.parseInt(params.get(0)), 
                Integer.parseInt(params.get(1))
        );
        
        dspecialty.disconnect();
        return res;
    }
    
     public ArrayList<String[]> display() throws SQLException {
        ArrayList<String[]> doctor_especialidades = (ArrayList<String[]>) dspecialty.display();
        dspecialty.disconnect();
        return doctor_especialidades;
    }
    
    public String delete(int id_specialty, String id_user) throws SQLException{
        
        String res = dspecialty.delete(id_specialty,id_user);
        
        dspecialty.disconnect();
        return res;
    }
    
     public String update(List<String> params) throws SQLException{
        
        String res = dspecialty.update(
                Integer.parseInt(params.get(0)), 
                params.get(1),
                Integer.parseInt(params.get(2)), 
                params.get(3)
                 
        );
        
        dspecialty.disconnect();
        return res;
    }
}
