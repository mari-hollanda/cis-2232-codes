/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.hccis.performancehallapp.bo;

import info.hccis.performancehallapp.exception.OrderInvalidException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing methods
 *
 * @since 20211126
 * @author mhollandacampos
 */
public class OrderJUnitTest {

    public OrderJUnitTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Testing to show that if the number of ticket is equals to 0 the cost will be 0.
     *
     * @since 20211126
     * @author mhollandacampos
     */
    @Test
    public void test_calculateCost_0_tickets_noHollPass() {

        try {
            Order ord = new Order();
            ord.setNumberOfTickets(0);
            ord.setHasHollpass(false);
            double costActual = ord.calculateCost();
            double costExpected = 0;
            Assertions.assertEquals(costExpected, costActual);
        } catch (OrderInvalidException ex) {
            //No need for anything. 
        }
    }
    
    /**
     * Testing to show that if the number of ticket is less than 10
     * when you don't have a Holl Pass the cost will be the cost of the ticket.
     *
     * @since 20211126
     * @author mhollandacampos
     */
    @Test
    public void test_calculateCost_5_tickets_noHollPass() {
        try {
            Order ord = new Order();
            ord.setNumberOfTickets(5);
            ord.setHasHollpass(false);
            double costActual = ord.calculateCost();
            double costExpected = 50;
            Assertions.assertEquals(costExpected, costActual);
        } catch (OrderInvalidException ex) {
            //No need for anything. 
        }
    }

    /**
     * Testing to show that if the number of ticket is equals to 20
     * when you don't have a Holl Pass the cost will be the cost of the ticket - 15%.
     *
     * @since 20211126
     * @author mhollandacampos
     */
    @Test
    public void test_calculateCost_20_tickets_noHollPass() {
        try {
            Order ord = new Order();
            ord.setNumberOfTickets(20);
            ord.setHasHollpass(false);
            double costActual = ord.calculateCost();
            double costExpected = 170;
            Assertions.assertEquals(costExpected, costActual);
        } catch (OrderInvalidException ex) {
            //No need for anything. 
        }
    }

     /**
     * Testing to show that if the number of ticket is equals to 10
     * when you have a Holl Pass the cost will be the cost of the ticket - 20%.
     *
     * @since 20211126
     * @author mhollandacampos
     */
    @Test
    public void test_calculateCost_10_tickets_hasHollPass() {
        try {
            Order ord = new Order();
            ord.setNumberOfTickets(10);
            ord.setHasHollpass(true);
            double costActual = ord.calculateCost();
            double costExpected = 80;
            Assertions.assertEquals(costExpected, costActual);
        } catch (OrderInvalidException ex) {
            //No need for anything. 
        }
    }

     /**
     * Testing to show that if the number of ticket is equals to 20
     * when you have a Holl Pass the cost will be the cost of the ticket - 25%.
     *
     * @since 20211126
     * @author mhollandacampos
     */
    @Test
    public void test_calculateCost_20_tickets_hasHollPass() {
        try {
            Order ord = new Order();
            ord.setNumberOfTickets(20);
            ord.setHasHollpass(true);
            double costActual = ord.calculateCost();
            double costExpected = 150;
            Assertions.assertEquals(costExpected, costActual);
        } catch (OrderInvalidException ex) {
            //No need for anything. 
        }
    }

     /**
     * Testing to show that if the number of ticket is more than 20
     * when you have a Holl Pass the cost will be the cost of the ticket - 25%.
     *
     * @since 20211126
     * @author mhollandacampos
     */
    @Test
    public void test_calculateCost_30_tickets_hasHollPass() {
        try {
            Order ord = new Order();
            ord.setNumberOfTickets(30);
            ord.setHasHollpass(true);
            double costActual = ord.calculateCost();
            double costExpected = 225;
            Assertions.assertEquals(costExpected, costActual);
        } catch (OrderInvalidException ex) {
            //No need for anything. 
        }
    }

     /**
     * Testing to show that if the number of ticket is negative
     * It should throw an Exception
     *
     * @since 20211126
     * @author mhollandacampos
     */
    @Test
    public void test_calculateCost_negative8_tickets_noHollPass() {
        Order ord;
        try {
            ord = new Order();
            ord.setNumberOfTickets(-8);
            ord.setHasHollpass(false);
            Assertions.fail("Exception for invalid number of tickets not thrown");
        } catch (OrderInvalidException ex) {
            //No need for anything. 
        }

    }

     /**
     * Validating the Holl Pass. 
     * If it's a number that can be divided by 13 the Holl Pass is valid.
     *
     * @since 20211126
     * @author mhollandacampos
     */
    @Test
    public void test_hollpassValidation_2732600() {
        Order ord = new Order();
        boolean costActual = ord.validate(2732600);
        boolean costExpected = true;
        Assertions.assertEquals(costExpected, costActual);
    }

     /**
     * Validating the Holl Pass. 
     * If it's not a number that can be divided by 13 the Holl Pass is invalid.
     *
     * @since 20211126
     * @author mhollandacampos
     */
    @Test
    public void test_hollpassValidation_3649855() {
        Order ord = new Order();
        boolean costActual = ord.validate(3649855);
        boolean costExpected = false;
        Assertions.assertEquals(costExpected, costActual);
    }
    
     /**
     * Validating the Holl Pass. 
     * If it's a negative number the Holl Pass is invalid.
     *
     * @since 20211126
     * @author mhollandacampos
     */
    @Test
    public void test_hollpassValidation_negative2732600() {
        Order ord = new Order();
        boolean costActual = ord.validate(-2732600);
        boolean costExpected = false;
        Assertions.assertEquals(costExpected, costActual);
    }

}
