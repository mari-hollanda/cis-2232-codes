package info.hccis.sample.controllers;

import info.hccis.sample.bo.CodeValueBO;
import info.hccis.sample.repositories.StudentRepository;
import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    
    private final StudentRepository _sr;

    @Autowired
    public BaseController(StudentRepository sr) {
        _sr = sr;
    }
    
    @RequestMapping("/")
    public String home(HttpSession session) {
        CodeValueBO codeValueBO = new CodeValueBO();
        session.setAttribute("courses", codeValueBO.selectCodeValues(2));  //Courses == 2

        //Put the students in the session
        session.setAttribute("students", _sr.findAll());
        
        return "index";
    }

    @RequestMapping("/about_bj")
    public String about() {
        System.out.println("The about_bj action was picked up by this controller.");
        System.out.println("This controller is now going to send the user to a different view (about_bj.html)");
        return "other/about_bj";
    }

    @RequestMapping("/about_bj2")
    public String about2() {
        return "other/about_bj2";
    }

    @RequestMapping("/future")
    public String future() {
        return "other/future";
    }

}
