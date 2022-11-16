package info.hccis.sample.entity;

import java.util.ArrayList;

/**
 * Class to hold report data
 * @author bjmaclean
 * @since 20211001
 */
public class ReportDetailStudent {
    
    private String courseName;
    private String courseNameForStudentsFound;

    ArrayList<String> names = new ArrayList();
    
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public String getCourseNameForStudentsFound() {
        return courseNameForStudentsFound;
    }

    public void setCourseNameForStudentsFound(String courseNameForStudentsFound) {
        this.courseNameForStudentsFound = courseNameForStudentsFound;
    }

    
    
    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    
    
    @Override
    public String toString() {
        return "Report: " + "courseName=" + courseName;
    }
    
    
    
}
