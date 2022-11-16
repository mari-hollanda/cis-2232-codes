package info.hccis.performancehallapp.bo;

import info.hccis.performancehallapp.exception.OrderInvalidException;
import java.util.Scanner;

public class Order {

    public static final double TEN_PERCENT_DISCOUNT = 0.1;
    public static final double FIFTEEN_PERCENT_DISCOUNT = 0.15;
    public static final double HOLLPASS_DISCOUNT = 0.1;
    
    private int numberOfTickets;
    private boolean hasHollpass;
    private double discount = 0;
    private double cost = 10;

    public Order() {

    }

    public Order(int numberOfTickets, boolean hasHollpass) {
        this.numberOfTickets = numberOfTickets;
        this.hasHollpass = hasHollpass;
    }

    /**
     * Calculate the cost
     *
     * @since 20211126
     * @author Marianna Hollanda
     */
    public double calculateCost() {

        if (hasHollpass == true && numberOfTickets > 0 && numberOfTickets < 10) {
            discount = HOLLPASS_DISCOUNT;
        } 
        else if (hasHollpass == true && numberOfTickets >= 10 && numberOfTickets < 20) {
            discount = HOLLPASS_DISCOUNT + TEN_PERCENT_DISCOUNT;
        } 
        else if (hasHollpass == true && numberOfTickets >= 20) {
            discount = HOLLPASS_DISCOUNT + FIFTEEN_PERCENT_DISCOUNT;
        } 
        else if (!hasHollpass && numberOfTickets > 0 && numberOfTickets >= 10 && numberOfTickets < 20) {
            discount = TEN_PERCENT_DISCOUNT;
        } 
        else if (!hasHollpass && numberOfTickets >= 20) {
            discount = FIFTEEN_PERCENT_DISCOUNT;
        }else{
            discount = 0;
        }
        
        cost = numberOfTickets * cost;
        cost = cost - (cost * discount);
        
        return cost;
    }

    /**
     * Holl Pass validation
     *
     * @since 20211126
     * @author Marianna Hollanda
     */
    public static boolean validate(int hollPassNumber) {
        if(hollPassNumber%13 == 0 && hollPassNumber > 0){
            return true;
        }else{
            return false;
        }
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) throws OrderInvalidException {
        
        checknumberOfTickets(numberOfTickets);
        this.numberOfTickets = numberOfTickets;
    }

    public boolean isHasHollpass() {
        return hasHollpass;
    }

    public void setHasHollpass(boolean hasHollpass) {
        this.hasHollpass = hasHollpass;
    }

    public double getDiscount() {
        return discount;
    }

    public double getCost() {
        return cost;
    }

    public void getInformation() {
        System.out.println("Enter number of tickets:");
        Scanner input = new Scanner(System.in);
        numberOfTickets = input.nextInt();
        input.nextLine();
        System.out.println("Do you have a Hollpass? (y/n)");
        String hollpassYN = input.nextLine();

        hasHollpass = hollpassYN.equalsIgnoreCase("Y") ? true : false;
        //OR could do it this way
        if (hollpassYN.equalsIgnoreCase("Y")) {
            hasHollpass = true;
        } else {
            hasHollpass = false;
        }
    }

     /**
     * Method to validate the number of tickets. Exception will be thrown if invalid.
     * 
     * @param numberOfTickets
     * @throws info.hccis.performancehallapp.exception.OrderInvalidException
     * @since 20211126
     * @author Marianna Hollanda
     */
    public void checknumberOfTickets(int numberOfTickets) throws OrderInvalidException {
        if (numberOfTickets < 0) {
            throw new OrderInvalidException("Tickets cannot be less to 0.");
        }
    }
    
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Order: # Tickets: " + numberOfTickets + "\nHas Holl Pass:" + hasHollpass + "\nDiscount: " + discount + "\nCost:" + cost;
    }

}
