/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import data.History;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VICTUS
 */
public class HistoryBusiness {
    private History History;
    
    public HistoryBusiness(){
        this.History = new History();
    }
    
    
    public ArrayList<String[]> display(String id) throws SQLException {
        ArrayList<String[]> historicos = (ArrayList<String[]>) History.display(id);
        History.disconnect();
        return historicos;
    }
    
}
