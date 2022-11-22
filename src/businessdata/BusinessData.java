
package businessdata;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import business.UserBusiness;
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
       
        displayUser();
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
    
    public static void displayReservation() throws SQLException{
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

}
