package performance.hall;

import info.hccis.util.CisUtility;
import performance.hall.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static performance.hall.Controller.MENU;
import static performance.hall.Controller.ticketsSold;
import static performance.hall.Controller.totalSales;
import performance.hall.entity.Order;

/**
 *
 * @author mhollandacampos
 */
public class Runner extends Thread {

    @Override
    public void run() {
        String option = "";

        while (!option.equalsIgnoreCase("0")) {
            option = CisUtility.getInputString(MENU, false);
            option = option.toUpperCase();
            switch (option) {
                case "1":
                    Order order = new Order();
                    order.processOrder(false);
                    order.display(false);
                    ticketsSold = ticketsSold + order.getNumberOfTickets();
                    totalSales = totalSales + order.getCost();
                    break;
                case "2":
                    showSummary(false);
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
