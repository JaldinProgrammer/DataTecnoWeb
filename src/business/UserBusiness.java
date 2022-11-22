/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos.jaldin
 */
public class UserBusiness {
    private User user;
    
    public UserBusiness(){
        this.user = new User();
    }
    
    public String create(List<String> params) throws SQLException{
        
        String res = user.create(
                Integer.parseInt(params.get(0)), 
                params.get(1), 
                params.get(2),
                params.get(3),
                params.get(4),
                params.get(5)
        );
        
        user.disconnect();
        return res;
    }
    
    public ArrayList<String[]> display() throws SQLException {
        ArrayList<String[]> usuarios = (ArrayList<String[]>) user.display();
        user.disconnect();
        return usuarios;
    }
}