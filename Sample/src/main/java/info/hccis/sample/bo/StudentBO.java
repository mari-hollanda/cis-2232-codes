package info.hccis.sample.bo;

/**
 * Student Business Object
 *
 * @author marianna hollanda
 * @since 20211207
 */
public class StudentBO {

    public static int determineStartingHollPassBalance(String program) {
        if (program.equalsIgnoreCase("CIS")) {
            return 1000;
        } else if (program.equalsIgnoreCase("CNET")) {
            return 750;
        } else {
            return 500;
        }
    }
}
