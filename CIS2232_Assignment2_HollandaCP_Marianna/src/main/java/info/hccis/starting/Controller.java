package info.hccis.starting;

import info.hccis.starting.bo.ApiProcessor;
import info.hccis.util.CisUtility;
import java.util.Scanner;

/**
 * Assignment 2 - API Processor
 *
 * @author marianna hollanda
 * @since 2021-11-05
 */
public class Controller {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //This API is slow, it takes a little bit of time to load.
        
        System.out.println("Welcome to the Bored API!");
        System.out.println("Are you looking for something to do?(y)");

        String answer = in.nextLine();

        while (answer.equals("y") || answer.equals("Y")) {
            String activity = ApiProcessor.callApi();
            System.out.println("Your activity for today is: " + activity);
            System.out.println("Are you satisfied with this activity? Do you need a new one? (y/n)");
            answer = in.nextLine();
        }
    }

}
