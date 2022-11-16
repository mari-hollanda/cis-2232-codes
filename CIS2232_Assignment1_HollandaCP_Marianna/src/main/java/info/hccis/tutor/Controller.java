package info.hccis.tutor;

import com.google.gson.Gson;
import info.hccis.tutor.bo.Business;
import info.hccis.tutor.bo.Employee;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * A project to track tutor transactions.
 *
 * @author bjmaclean
 * @since 20200617
 * @modified by Marianna Hollanda
 * @since 20210921
 * Added requirements for Assignment 1
 */
public class Controller {
    
   private static final String FOLDER_NAME = "/cis2232";
   private static final String FILE_NAME = "tutors.txt";
    
   public static void main(String[] args) {

       Business.showBusinessInformation();
       
       //Source: Project Sandbox20210916 done in class.
       File file = new File(FOLDER_NAME);
       boolean dirCreated = file.mkdir();
       
       ArrayList <String> linesFromFile = null;
       
       try{
           linesFromFile = (ArrayList) Files.readAllLines(Paths.get(FOLDER_NAME+"\\"+FILE_NAME));
       } catch (IOException ex) {
            System.out.println("There was an exception reading the file");
        }
       
       ArrayList<Employee> employees = new ArrayList();
       
       boolean foundEmployees = linesFromFile != null;
       
       Gson gson = new Gson();
       
       if(foundEmployees){
           System.out.println("Loading tutors from the file:");
           System.out.println("");
           for(String current: linesFromFile){
               if(current.length() > 1){
                   System.out.println(current);
                   
                   Employee employee = gson.fromJson(current, Employee.class);
                   employees.add(employee);
               }
           }
           System.out.println("");
           System.out.println("Finished loading tutors.");
           System.out.println("");
       }else{
           System.out.println("There are no tutors to load.");
       }
       
       //Show the students that were loaded.
       System.out.println("Here are the tutors that were loaded from the file:");
       System.out.println("");
       
       for(Employee current: employees){
           System.out.println(current.toString());
       }
       
       System.out.println("These are the tutors in the file.");
       System.out.println("");
       System.out.println("Add a new tutor:");
       System.out.println("");
       
       //Create a new tutor       
       Employee employee = new Employee();
       employee.getInformtion();
       
       //Write the new tutor to the file.
       FileWriter fileWriter;
       try{
           fileWriter = new FileWriter(FOLDER_NAME+"\\"+FILE_NAME, true);
            fileWriter.write(gson.toJson(employee) + System.lineSeparator());
            fileWriter.flush();
            //fileWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing.");
            ex.printStackTrace();
        }
       
       System.out.println("Done! Thank you for using the program.");
       
      // employee.display();
       
    }
}
