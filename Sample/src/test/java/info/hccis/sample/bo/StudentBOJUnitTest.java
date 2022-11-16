package info.hccis.sample.bo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Student BO Unit Tests
 *
 * @author marianna hollanda
 * @since 20211207
 */
public class StudentBOJUnitTest {

    public StudentBOJUnitTest() {
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
     * Testing to show that if the user type CIS will have the balance of 1000
     *
     * @author marianna hollanda
     * @since 20211207
     */
    @Test
    public void test_calculateCIS() {

        StudentBO stu = new StudentBO();
        int costActual = stu.determineStartingHollPassBalance("CIS");
        int costExpected = 1000;

        Assertions.assertEquals(costExpected, costActual);
    }

    /**
     * Testing to show that if the user type CNET will have the balance of 1000
     *
     * @author marianna hollanda
     * @since 20211207
     */
    @Test
    public void test_calculateCNET() {

        StudentBO stu = new StudentBO();
        int costActual = stu.determineStartingHollPassBalance("CNET");
        int costExpected = 750;

        Assertions.assertEquals(costExpected, costActual);
    }

}
