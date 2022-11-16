package info.hccis.sample.entity;

import java.util.ArrayList;

/**
 * Class to hold report data
 * @author bjmaclean
 * @since 20211001
 */
public class ReportDetailCourse {
    
    private int id;
    private String studentNameForCoursesFound;

    ArrayList<String> courses = new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNameForCoursesFound() {
        return studentNameForCoursesFound;
    }

    public void setStudentNameForCoursesFound(String studentNameForCoursesFound) {
        this.studentNameForCoursesFound = studentNameForCoursesFound;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }
    
    
}
