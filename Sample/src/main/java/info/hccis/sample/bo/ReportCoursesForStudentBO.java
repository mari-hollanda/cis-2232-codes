package info.hccis.sample.bo;

import info.hccis.sample.dao.ReportCoursesForStudentDAO;
import java.util.ArrayList;

/**
 *
 * @author bjmaclean
 */
public class ReportCoursesForStudentBO {

    public ArrayList<String> selectCoursesForStudent(int id) {

        ReportCoursesForStudentDAO rcfsdao = new ReportCoursesForStudentDAO();
        return rcfsdao.selectCoursesForStudent(id);
    
    }
}