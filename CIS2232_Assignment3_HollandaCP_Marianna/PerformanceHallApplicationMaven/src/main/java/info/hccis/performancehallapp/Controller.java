package info.hccis.performancehallapp;

import info.hccis.performancehallapp.bo.Order;

/**
 * Sample program for Test Driven Development
 * @author bjmaclean
 * @since 20211122
 */
public class Controller {

    public static void main(String[] args) {
        
        Order order = new Order();
        order.getInformation();
        order.display();
        
    }
    
}
