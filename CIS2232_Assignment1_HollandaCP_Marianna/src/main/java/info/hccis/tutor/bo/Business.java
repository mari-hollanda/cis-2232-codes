package info.hccis.tutor.bo;

/**
 * Contains information about the business.
 *
 * @author bjm
 * @since 2020-06-19
 */
public class Business {

    public static final String BUSINESS_NAME = "College Tutorial Services";
    public static final String BUSINESS_ADDRESS = "140 Weymouth Street" + System.lineSeparator()
            + "Charlottetown, PE" + System.lineSeparator()
            + "C1A 1H6" + System.lineSeparator();

    public static void showBusinessInformation() {
        System.out.println(BUSINESS_NAME);
        System.out.println(BUSINESS_ADDRESS);
    }

}
