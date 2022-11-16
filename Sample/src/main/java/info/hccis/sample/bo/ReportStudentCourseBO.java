package info.hccis.sample.bo;

import info.hccis.sample.dao.ReportStudentCourseDAO;
import java.util.ArrayList;

/**
 * Contains the business logic for the student course report
 * @author bjmaclean
 * @since 20211001
 */
public class ReportStudentCourseBO {
    
    public ArrayList<String> getStudentNamesForCourseName(String name){
        ReportStudentCourseDAO reportStudentCourseDAO = new ReportStudentCourseDAO();
        return reportStudentCourseDAO.selectStudentNamesByCourseName(name);
    }

    
}
