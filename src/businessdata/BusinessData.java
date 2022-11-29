
package businessdata;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import business.UserBusiness;
import business.DiagnosticsBusiness;
import business.Diagnostic_symptomBusiness;
import business.Disease_symptomBusiness;
import business.Request_reservationsBusiness;
import business.ReservationBusiness;
import business.HistoryBusiness;
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
       
       PromotionsBusiness diagB= new PromotionsBusiness();
        List createdata = List.of( "6", "Prueba", "sigue siendo una prueba");
        List updatedata = List.of("6", "Prueba2", "sigue siendo una prueba 2");
//      List createdata = List.of("11", "2022-10-15", "9545444", "7" );
//         diagB.create(createdata );
        //diagB.update(updatedata);
//        diagB.delete(8, 20);
//       diagB.create(createdata);
       diagB.update(updatedata);
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
    
    public static void displayHistories() throws SQLException{
        HistoryBusiness diagB = new HistoryBusiness();
        Scanner lectura = new Scanner (System.in);
        System.out.println("Ingrese id");
       String id = lectura.next();
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
