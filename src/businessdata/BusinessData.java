
package businessdata;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import business.UserBusiness;
import business.SpecialtiesBusiness;
import business.Doctor_specialtiesBusiness;
import business.SymptomsBusiness;
import business.DiseasesBusiness;
import business.Disease_symptomsBusiness;

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
       
        //specialties ===========================================================
       List<String> createdata = List.of("9","Medicina General");
       List<String> updatedata = List.of("9","Medicina General2");
       SpecialtiesBusiness speB = new SpecialtiesBusiness();
      
      // speB.delete(9);//works ok
      // speB.create(createdata);// works ok 
      //speB.update(updatedata);//works ok
      //displayspecialties(); //works ok
      
      //Doctor_specialties ======================================================
      
       Doctor_specialtiesBusiness dspeB = new Doctor_specialtiesBusiness();
       List<String> createdata2 = List.of("9", "9574561");
       List<String> updatedata2 = List.of("8", "4294445","8", "0400070");
       //dspeB.create(createdata2);//works ok
       //dspeB.delete(9, "9574561"); //works ok
       //displaydoctorspecialties();//works ok
       //dspeB.update(updatedata2);//works ok 
       
       //Symptoms ===============================================================
       
       List<String> createdata3 = List.of("33","dolor de ojos");
       List<String> updatedata3 = List.of("33","dolor de ojos2");
       SymptomsBusiness sympB = new SymptomsBusiness();
       
       //sympB.create(createdata3);//works ok
       //sympB.delete(33);//works ok
       //sympB.update(updatedata3);//works ok
       //displaysymptoms();//works ok
       
      //Diseases ================================================================
       List<String> createdata4 = List.of("9","neumonia","neumonia");
       List<String> updatedata4 = List.of("9","neumonia2","neumonia2");
       DiseasesBusiness disB = new DiseasesBusiness();
       
       //disB.create(createdata4); //works ok
       //disB.update(updatedata4); //works ok
       //disB.delete(9); //works ok
       //displaydiseases(); // works ok
       
       //Disease_symptom ========================================================
       List<String> createdata5 = List.of("1","2");
       List<String> updatedata5 = List.of("1","2","1","3");
       Disease_symptomsBusiness dsB = new Disease_symptomsBusiness();
       
       //dsB.create(createdata5);//works ok
       //dsB.update(updatedata5);//works ok
       //dsB.delete(1, 3);//woks ok
       //displaydisease_symptoms();//works ok
       
      
    }
    
    public static void displayspecialties() throws SQLException{
        SpecialtiesBusiness speB = new SpecialtiesBusiness();
       ArrayList<String[]> valor = speB.display();
        for (int i = 0; i < valor.size(); i++) {
            String[] data = valor.get(i);
            System.out.println("----");
            for (int j = 0; j < data.length; j++) {
                System.out.println(data[j]);
            }
        }
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
    
    public static void displaydoctorspecialties() throws SQLException{
        Doctor_specialtiesBusiness dspeB = new Doctor_specialtiesBusiness();
       ArrayList<String[]> valor = dspeB.display();
        for (int i = 0; i < valor.size(); i++) {
            String[] data = valor.get(i);
            System.out.println("----");
            for (int j = 0; j < data.length; j++) {
                System.out.println(data[j]);
            }
        }
    }
    
    public static void displaysymptoms() throws SQLException{
         SymptomsBusiness sympB = new SymptomsBusiness();
       ArrayList<String[]> valor = sympB.display();
        for (int i = 0; i < valor.size(); i++) {
            String[] data = valor.get(i);
            System.out.println("----");
            for (int j = 0; j < data.length; j++) {
                System.out.println(data[j]);
            }
        }
    }
    
    public static void displaydiseases() throws SQLException{
         DiseasesBusiness disB = new DiseasesBusiness();
       ArrayList<String[]> valor = disB.display();
        for (int i = 0; i < valor.size(); i++) {
            String[] data = valor.get(i);
            System.out.println("----");
            for (int j = 0; j < data.length; j++) {
                System.out.println(data[j]);
            }
        }
    }
    
    public static void displaydisease_symptoms() throws SQLException{
         Disease_symptomsBusiness dsB = new Disease_symptomsBusiness();
       ArrayList<String[]> valor = dsB.display();
        for (int i = 0; i < valor.size(); i++) {
            String[] data = valor.get(i);
            System.out.println("----");
            for (int j = 0; j < data.length; j++) {
                System.out.println(data[j]);
            }
        }
    }

}
