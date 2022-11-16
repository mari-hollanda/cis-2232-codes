package performance.hall;

import info.hccis.util.CisUtility;
import performance.hall.entity.Order;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Sample program for Test Driven Development
 *
 * @author bjmaclean
 * @since 20211122
 * @modified by Marianna Hollanda
 * @since 20211203
 */
public class Controller {

    public static final String MENU = "Florence Simmons Hall Ticked Office Application" + System.lineSeparator()
            + "1) Make an order for tickets" + System.lineSeparator()
            + "2) Show summary" + System.lineSeparator()
            + "0) Exit;" + System.lineSeparator();

    public static double totalSales;
    public static double ticketsSold;

    public static void main(String[] args) {

        Runner runner = new Runner();
        runner.start();

        boolean userContinue = true;

        String option = "";

        while (!option.equalsIgnoreCase("0")) {
            option = CisUtility.getInputString(MENU, true);
            option = option.toUpperCase();
            switch (option) {
                case "1":
                    Order order = new Order();
                    order.processOrder(true);
                    order.display(true);
                    ticketsSold = ticketsSold + order.getNumberOfTickets();
                    totalSales = totalSales + order.getCost();
                    break;
                case "2":
                    showSummary(true);
                    break;
                case "0":
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    /**
     * Show Summary for the User.
     *
     * @author Marianna Hollanda
     * @since 20211203
     */
    private static void showSummary(boolean useConsole) {
        double average = totalSales / ticketsSold;

        if (useConsole) {
            System.out.println("Summary \nTotal sales: $" + totalSales + "\nTickets sold: " + ticketsSold + "\nAverage cost: $" + average + " per ticket." + "\n");
        } else {
            JOptionPane.showMessageDialog(null, "Summary \nTotal sales: $" + totalSales + "\nTickets sold: " + ticketsSold + "\nAverage cost: $" + average + " per ticket." + "\n");
        }
    }
}
