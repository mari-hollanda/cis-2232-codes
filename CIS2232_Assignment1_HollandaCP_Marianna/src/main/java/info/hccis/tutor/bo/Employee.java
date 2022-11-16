package info.hccis.tutor.bo;

import java.util.Scanner;

/**
 * Class represents an employee for tutorial services
 *
 * @author bjm
 * @since 2020-06-19
 */
public class Employee {

    public static final double COST_INDIVIDUAL = 15;
    public static final double COST_SMALL_GROUP = 17;
    public static final double COST_LARGE_GROUP = 20;

    private int id; //Unique sequential id for this employee
    private String name;
    private double hoursIndividual, hoursSmallGroup, hoursLargeGroup;
    private static int nextId;  //Used to hold the next available id

    /**
     * Default constructor
     *
     * @since 2020-06-19
     * @author BJM
     */
    public Employee() {
        //Increment the next id and assign it to this employees id.
        this.id = ++nextId;
    }

    /**
     * Custom constructor
     *
     * @since 2020-06-19
     * @author BJM
     */
    public Employee(String name, double hoursIndividual, double hoursSmallGroup, double hoursLargeGroup) {
        //Increment the next id and assign it to this employees id.
        this.id = ++nextId;
        this.name = name;
        this.hoursIndividual = hoursIndividual;
        this.hoursSmallGroup = hoursSmallGroup;
        this.hoursLargeGroup = hoursLargeGroup;
    }

    /**
     * Get information from the user
     *
     * @since 2020-06-19
     * @author BJM
     */
    public void getInformtion() {
        Scanner input = new Scanner(System.in);
        System.out.println("Tutor’s name?");
        name = input.nextLine();

        System.out.println("How many 'Individual' hours?");
        hoursIndividual = input.nextDouble();
        input.nextLine();  //burn

        System.out.println("How many 'Small Group' hours?");
        hoursSmallGroup = input.nextDouble();
        input.nextLine();  //burn

        System.out.println("How many 'Large Group' hours?");
        hoursLargeGroup = input.nextDouble();
        input.nextLine();  //burn
        
        System.out.println(""); //Empty line for formatting
    }

    /**
     * Returns the calculated earnings for this employee
     *
     * @since 2020-06-19
     * @author BJM
     */
    public double getEarnings() {
        double earnings = hoursIndividual * COST_INDIVIDUAL
                + hoursSmallGroup * COST_SMALL_GROUP
                + hoursLargeGroup * COST_LARGE_GROUP;
        return earnings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursIndividual() {
        return hoursIndividual;
    }

    public void setHoursIndividual(double hoursIndividual) {
        this.hoursIndividual = hoursIndividual;
    }

    public double getHoursSmallGroup() {
        return hoursSmallGroup;
    }

    public void setHoursSmallGroup(double hoursSmallGroup) {
        this.hoursSmallGroup = hoursSmallGroup;
    }

    public double getHoursLargeGroup() {
        return hoursLargeGroup;
    }

    public void setHoursLargeGroup(double hoursLargeGroup) {
        this.hoursLargeGroup = hoursLargeGroup;
    }

    public void display(){
        System.out.println(this.toString());
    }
    
    public String toString() {
        String output = "Summary for " + name
                + "\n"
                + "Number of 'Individual' hours: " + hoursIndividual
                + "\n"
                + "Number of 'Small Group' hours: " + hoursSmallGroup
                + "\n"
                + "Number of 'Large Group' hours: " + hoursLargeGroup
                + "\n"
                + "Earnings:  $" + getEarnings() + " \n"
                + "\n";
        return output;
    }
}
