/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.Diagnostics;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VICTUS
 */
public class DiagnosticsBusiness {
    private Diagnostics Diagnostics;
    
    public DiagnosticsBusiness(){
        this.Diagnostics = new Diagnostics();
    }
    
    public String create(List<String> params) throws SQLException{
        
        String res = Diagnostics.create(
                params.get(0), 
                params.get(1), 
                params.get(2)
        );
        
        Diagnostics.disconnect();
        return res;
    }
    
    public ArrayList<String[]> display(int id) throws SQLException {
        ArrayList<String[]> Diagnosticos = (ArrayList<String[]>) Diagnostics.display(id);
        Diagnostics.disconnect();
        return Diagnosticos;
    }
    
    public String delete(String id) throws SQLException{
        
        String res = Diagnostics.delete(id);
        
        Diagnostics.disconnect();
        return res;
    }
    
     public String update(List<String> params) throws SQLException{
        
        String res = Diagnostics.update(
                params.get(0), 
                params.get(1),
                params.get(2), 
                params.get(3)
        );
        
        Diagnostics.disconnect();
        return res;
    }
}
