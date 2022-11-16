package info.hccis.sample.dao;

import info.hccis.sample.entity.CodeValue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DAO class for student course report
 *
 * @author bjmaclean
 * @since 20211001
 */
public class CodeValueDAO {

    private static ResultSet rs;
    private static Statement stmt = null;
    private static Connection conn = null;

    public CodeValueDAO() {

        String propFileName = "application";
        ResourceBundle rb = ResourceBundle.getBundle(propFileName);
        System.out.println("bjtest datasource:  " + rb.getString("spring.datasource.url"));
        String connectionString = rb.getString("spring.datasource.url");
        String userName = rb.getString("spring.datasource.username");
        String password = rb.getString("spring.datasource.password");

        //String URL = "jdbc:mysql://" + "localhost" + ":3306/" + "cis2232_sample";
        try {
            conn = DriverManager.getConnection(connectionString, userName, password);
        } catch (Exception e) {
            System.out.println("Error");
        }

    }

    /**
     * Select all code values based on code type
     *
     * @since 20210924
     * @author BJM
     */
    public ArrayList<CodeValue> selectCodeValues(int codeTypeId) {
        Statement stmt = null;
        ArrayList<CodeValue> codes = new ArrayList();
        try {
            stmt = conn.createStatement();
            String query = "SELECT * FROM CodeValue cv WHERE cv.codeTypeId = "+codeTypeId+" ORDER BY cv.englishDescription;";
            System.out.println(query);
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Error");
            ex.printStackTrace();
        }

        try {
            while (rs.next()) {
                codes.add(new CodeValue(rs.getInt("codeTypeId"), rs.getInt(2), rs.getString(3)));
                System.out.println("Found a code value: "+rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CodeValueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codes;
    }

}
