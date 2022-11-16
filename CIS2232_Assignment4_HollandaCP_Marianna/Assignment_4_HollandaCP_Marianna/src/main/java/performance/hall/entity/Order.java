package performance.hall.entity;

import info.hccis.util.CisUtility;
import javax.swing.JOptionPane;

/**
 * Order Class
 *
 * @author BJM
 * @modified by Marianna Hollanda
 * @since 20211203
 */
public class Order {

    public static final double TEN_PERCENT_DISCOUNT = 0.1;
    public static final double FIFTEEN_PERCENT_DISCOUNT = 0.15;
    public static final double HOLLPASS_DISCOUNT = 0.1;
    private int numberOfTickets;
    private boolean hasHollpass;
    private double discount;
    private double cost;
    private String name;

    public Order() {

    }

    public Order(int numberOfTickets, boolean hasHollpass) {
        this.numberOfTickets = numberOfTickets;
        this.hasHollpass = hasHollpass;
    }

    public void processOrder(boolean userConsole) {

        if (userConsole) {
            getInformation(true);
        } else {
            getInformation(false);
        }

        cost = calculateCost();
    }

    public double calculateCost() {
        int ticketPrice = 10;
        if (hasHollpass == true && numberOfTickets > 0 && numberOfTickets < 10) {
            discount = HOLLPASS_DISCOUNT;
        } else if (hasHollpass == true && numberOfTickets >= 10 && numberOfTickets < 20) {
            discount = HOLLPASS_DISCOUNT + TEN_PERCENT_DISCOUNT;
        } else if (hasHollpass == true && numberOfTickets >= 20) {
            discount = HOLLPASS_DISCOUNT + FIFTEEN_PERCENT_DISCOUNT;
        } else if (!hasHollpass && numberOfTickets > 0 && numberOfTickets >= 10 && numberOfTickets < 20) {
            discount = TEN_PERCENT_DISCOUNT;
        } else if (!hasHollpass && numberOfTickets >= 20) {
            discount = FIFTEEN_PERCENT_DISCOUNT;
        } else {
            discount = 0;
        }

        cost = numberOfTickets * ticketPrice;
        cost = cost - (cost * discount);

        return cost;
    }

    public static boolean validate(int hollPassNumber) {
        if (hollPassNumber % 13 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public boolean isHasHollpass() {
        return hasHollpass;
    }

    public void setHasHollpass(boolean hasHollpass) {
        this.hasHollpass = hasHollpass;
    }

    public double getDiscount() {
        discount = .1;
        return discount;
    }

    public double getCost() {
        return calculateCost();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getInformation(boolean useConsole) {
        name = CisUtility.getInputString("Enter name:", useConsole);
        numberOfTickets = CisUtility.getInputInt("Enter number of tickets:", useConsole);

        String hollpassYN = CisUtility.getInputString("Do you have a Hollpass? (y/n)", useConsole);

        hasHollpass = hollpassYN.equalsIgnoreCase("Y") ? true : false;
        //OR could do it this way
        if (hollpassYN.equalsIgnoreCase("Y")) {

            while (!validate(CisUtility.getInputInt("Please enter your HollPass number:", useConsole))) {
                System.out.println("Please enter an valid HollPass number.");
            }
            hasHollpass = true;

        } else {
            hasHollpass = false;
        }
    }

    public void display(boolean useConsole) {
        if (useConsole) {
            System.out.println(toString());
        } else {
            JOptionPane.showMessageDialog(null, toString());
        }

    }

    @Override
    public String toString() {
        return "Thank you for your order!"
                + "\nName: " + name
                + "\nNumber of tickets: " + numberOfTickets
                + "\nRegular cost: $" + numberOfTickets * 10
                + "\nDiscount: " + discount * 100 + "%"
                + "\nCost: $" + cost + "\n";
    }

}
