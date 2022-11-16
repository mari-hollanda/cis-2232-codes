package info.hccis.sample.dao;

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
public class ReportStudentCourseDAO {

    private static ResultSet rs;
    private static Statement stmt = null;
    private static Connection conn = null;

    public ReportStudentCourseDAO() {

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
     * Select a student by name
     *
     * @since 20210924
     * @author BJM
     */
    public ArrayList<String> selectStudentNamesByCourseName(String courseName) {
        Statement stmt = null;
        ArrayList<String> names = new ArrayList();
        try {
            stmt = conn.createStatement();
            String query = "SELECT s.name from Student s WHERE s.studentId in ("
                    + "SELECT sc.studentId from StudentCourse sc WHERE sc.studentCourse = "
                    + "(SELECT cv.codeValueSequence FROM CodeValue cv "
                    + "where cv.englishDescription = '" + courseName
                    + "' and cv.codeTypeId = 2));";
            System.out.println(query);
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Error");
            ex.printStackTrace();
        }

        try {
            while (rs.next()) {
                names.add(rs.getString(1));
                System.out.println("Found a student: "+rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportStudentCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return names;
    }

}
