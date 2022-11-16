package info.hccis.sample.controllers;

import info.hccis.sample.bo.ReportCoursesForStudentBO;
import info.hccis.sample.entity.ReportDetailCourse;
import info.hccis.sample.repositories.StudentRepository;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports/course")
public class ReportsCourseController {

    private final StudentRepository _sr;

    @Autowired
    public ReportsCourseController(StudentRepository sr) {
        _sr = sr;
    }

    /**
     * This method will take the user to the reports-course-input. It will send
     * the user to the view to allow them to specify the student and give a
     * button which will trigger running the report.
     *
     * @param model model object injected into the method to allow us to store
     * report detail object which is used on the view.
     * @return Return to the templates.reports.course.html
     *
     * @since 20211014
     * @author BJM
     */
    @RequestMapping("/input")
    public String goToInput(Model model, HttpSession session) {
        System.out.println("this action will send to the courses for student report report input view");

        //***********************************************************************
        // The following line of code will put a report detail course object in the 
        // model.  This is needed to allow the html file input fields to be associated
        // with attributes of an object.  
        //**********************************************************************
        model.addAttribute("reportDetailCourse", new ReportDetailCourse());

        //******************************************************************
        // Reload the students in the session collection
        //******************************************************************
        session.setAttribute("students", _sr.findAll());

        return "reports/course";
    }

    /**
     * This method will be triggered when the user submits the report. It will
     * use the BO functionality to obtain the report results and return the user
     * to the report view to see the results.
     *
     * @param model
     * @param reportDetailCourse This is the object which was associated with
     * the view. The object will have the fields associated with inputs on the
     * html page to contain the values which were provided on the html page.
     * @return to the same report view
     *
     * @since 20211014
     * @author BJM
     */
    @RequestMapping("/submit")
    public String submitStudentCourseReport(Model model, @ModelAttribute("reportDetailCourse") ReportDetailCourse reportDetailCourse) {

        //***********************************************************************
        //Invoke model business logic which will access the database
        //***********************************************************************
        ReportCoursesForStudentBO rcfsbo = new ReportCoursesForStudentBO();
        ArrayList<String> courses = rcfsbo.selectCoursesForStudent(reportDetailCourse.getId());

        //**********************************************************************
        // Put the results in a Java object.  This will contain the list with the results
        // and allow the view to have data to show.
        //**********************************************************************
        reportDetailCourse.setCourses(courses);
        reportDetailCourse.setId(0); //reset the id provided back to 0.

        //***********************************************************************
        // Set a String in memory which can be used to show a message to the user.
        //***********************************************************************
        if (courses.isEmpty()) {
            model.addAttribute("message", "No courses found");
        } else {
            model.addAttribute("message", "Course report loaded");
        }

        //***********************************************************************
        // Put the object in the model - this is needed to make it available to the 
        // html view.
        //***********************************************************************
        model.addAttribute("reportDetailCourse", reportDetailCourse);

        //Send the user back to the report view.  see other sources / templates.reports/course.html
        return "reports/course";
    }

}
