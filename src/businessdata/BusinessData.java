
package businessdata;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import business.UserBusiness;
import business.DiagnosticsBusiness;
import business.Diagnostic_symptomBusiness;
import business.Disease_symptomBusiness;
import business.Request_reservationsBusiness;
import business.ReservationBusiness;
import business.PromotionsBusiness;
/**
 *
 * @author carlos.jaldin
 */
public class BusinessData {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException, SQLException {
       displayDiagnostics();
    }
    
    public static void displayUser() throws SQLException{
        UserBusiness userB = new UserBusiness();
       ArrayList<String[]> valor = userB.display();
        for (int i = 0; i < valor.size(); i++) {
            String[] data = valor.get(i);
            System.out.println("----");
            for (int j = 0; j < data.length; j++) {
                System.out.println(data[j]);
            }
        }
    }
    
    public static void displayDiagnostics() throws SQLException{
        DiagnosticsBusiness diagB = new DiagnosticsBusiness();
        Scanner lectura = new Scanner (System.in);
        System.out.println("Ingrese id");
        int id = Integer.parseInt(lectura.next());
       ArrayList<String[]> valor = diagB.display(id);
        for (int i = 0; i < valor.size(); i++) {
            String[] data = valor.get(i);
            System.out.println("----");
            for (int j = 0; j < data.length; j++) {
                System.out.println(data[j]);
            }
        }
    }
    
    public static void displayPromotions() throws SQLException{
        PromotionsBusiness proB = new PromotionsBusiness();
       ArrayList<String[]> valor = proB.display();
        for (int i = 0; i < valor.size(); i++) {
            String[] data = valor.get(i);
            System.out.println("----");
            for (int j = 0; j < data.length; j++) {
                System.out.println(data[j]);
            }
        }
    }

}
