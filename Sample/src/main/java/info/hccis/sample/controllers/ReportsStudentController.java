package info.hccis.sample.controllers;

import info.hccis.sample.bo.CodeValueBO;
import info.hccis.sample.bo.ReportStudentCourseBO;
import info.hccis.sample.entity.CodeValue;
import info.hccis.sample.entity.ReportDetailStudent;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports/student")
public class ReportsStudentController {

    @RequestMapping("/input")
    public String about(Model model, HttpSession session) {
        System.out.println("this action will send to the student course report input view");
        model.addAttribute("reportDetailStudent", new ReportDetailStudent());

        //Check to see if the courses collection is in the session
        ArrayList<CodeValue> courses = (ArrayList<CodeValue>) session.getAttribute("courses");
        if (courses == null || courses.isEmpty()) {
            CodeValueBO codeValueBO = new CodeValueBO();
            session.setAttribute("courses", codeValueBO.selectCodeValues(2));  //Courses == 2
        }

        return "reports/student";
    }

    @RequestMapping("/submit")
    public String submitStudentCourseReport(Model model, @ModelAttribute("reportDetailStudent") ReportDetailStudent reportDetailStudent) {
        System.out.println("submitting to run the report: " + reportDetailStudent.getCourseName());

        //Invoke model business logic which will access the database
        ReportStudentCourseBO rscbo = new ReportStudentCourseBO();
        ArrayList<String> names = rscbo.getStudentNamesForCourseName(reportDetailStudent.getCourseName());

        reportDetailStudent.setNames(names);
        reportDetailStudent.setCourseNameForStudentsFound(reportDetailStudent.getCourseName());
        reportDetailStudent.setCourseName("");

        if (names.isEmpty()) {
            model.addAttribute("message", "No students found");
        } else {
            model.addAttribute("message", "Student report loaded");
        }

        model.addAttribute("reportDetailStudent", reportDetailStudent);

        return "reports/student";
    }

}
