package info.hccis.sample.dao;

import info.hccis.sample.entity.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.apache.logging.log4j.message.MapMessage.MapFormat.names;

/**
 * DAO class for courses for student report
 *
 * @author bjmaclean
 * @since 20211008
 */
public class ReportCoursesForStudentDAO {

    private static ResultSet rs;
    private static Statement stmt = null;
    private static Connection conn = null;

    public ReportCoursesForStudentDAO() {

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
     * Select courses for a student  by student id
     *
     * @since 20210924
     * @author BJM
     */
    public ArrayList<String> selectCoursesForStudent(int id) {
        Statement stmt = null;
        ArrayList<String> courses = new ArrayList();
        try {
            stmt = conn.createStatement();
            String query = "SELECT * FROM Codevalue cv "
                    + "WHERE cv.codeTypeId = 2 "
                    + "and cv.codeValueSequence "
                    + "in (select sc.studentCourse from "
                    + "StudentCourse sc where sc.studentId = "+id+");";
            System.out.println(query);
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Error");
            ex.printStackTrace();
        }

        try {
            while (rs.next()) {
                courses.add(rs.getString("englishDescription"));
                System.out.println("Found a course: "+rs.getString("englishDescription"));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException line 75 ");
        }
        return courses;
    }

}
