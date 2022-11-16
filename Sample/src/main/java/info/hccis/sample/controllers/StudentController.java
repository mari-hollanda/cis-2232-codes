package info.hccis.sample.controllers;

import info.hccis.sample.bo.StudentBO;
import info.hccis.sample.entity.Student;
import info.hccis.sample.repositories.StudentRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the student functionality of the site
 *
 * @since 20211014
 * @author CIS2232
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository _sr;

    @Autowired
    public StudentController(StudentRepository sr) {
        _sr = sr;
    }

    /**
     * Lists all students
     *
     * @since 20211014
     * @author BJM
     */
    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("students", _sr.findAll());

        Student student = new Student();
        model.addAttribute("student", student);

        return "student/list";
    }

    /**
     * add a students
     *
     * @since 20211014
     * @author BJM
     */
    @RequestMapping("add")
    public String add(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/add";
    }

    /**
     * Search for a student
     *
     * @since 20211028
     * @author BJM
     */
    @RequestMapping("/search")
    public String search(Model model, @ModelAttribute("student") Student student) {

        //Validate that the student name is entered
        if (student.getName().isEmpty()) {
            String message = "Can not search without name";
            model.addAttribute("message", message);
            model.addAttribute("students", _sr.findAll());
            return "student/list";
        }

        System.out.println("search for " + student.getName());

        //Find the student with that name from the database
        Student studentLoaded = _sr.findByName(student.getName());

        if (studentLoaded == null) {
            System.out.println("Could not find student.name=" + student.getName());
            String message = "Could not find a student with that name";
            model.addAttribute("message", message);
            model.addAttribute("students", _sr.findAll());
            return "student/list";
        }

        System.out.println("Loaded a student based on name: " + studentLoaded.toString());
        model.addAttribute("student", studentLoaded);
        return "student/add";
    }

    /**
     * Submit method that processes add and edit and any form submission
     *
     * @since 20211015
     * @author CIS2232
     */
    @RequestMapping("/submit")
    public String submit(Model model, @Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("Validation error");
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }

            return "student/add";
        }

        _sr.save(student);
        model.addAttribute("students", _sr.findAll());
        return "student/list";
    }

//
//    /**
//     * Page to edit member
//     * @since 20191212
//     * @author Fred Campos
//     */
//    @RequestMapping("/edit/{id}")
//    public String edit(@PathVariable int id, Model model) {
//        MemberEntity member = _ms.createMemberTransient(id);
//        if (member != null) {
//            model.addAttribute("member", member);
//            model.addAttribute("statuses", _cvr.findCodeValueEntitiesByCodeTypeId(3));
//            return "members/member";
//        }
//        return "redirect:/members";
//    }
//
    /**
     * Page to delete a student
     *
     * @since 20211025
     * @author Fred Campos
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        _sr.deleteById(id);
        return "redirect:/student";
    }
//
//
//    /**
//     * Page to allow member to view member bookings
//     * @since 20191212
//     * @author Fred Campos
//     */
//    @RequestMapping("/bookings")
//    public String showBookingSearch(Model model) {
//        model.addAttribute("members", _ms.createMemberTransient());
//
//        return "members/bookingSearch";
//    }
//
//    /**
//     * Shows the bookings the member selected
//     * @since 20191212
//     * @author Fred Campos
//     */
//    @RequestMapping("/booking")
//    public String showBooking(Model model, @RequestParam int userId, @RequestParam String start, @RequestParam String end) {
//        model.addAttribute("bookings", _ms.findMemberBookings(userId, start, end));
//        return "members/bookings";
//    }
//
//    /**
//     * Export to file functionality
//     * @since 20191212
//     * @author Fred Campos
//     */
//    @RequestMapping("/export")
//    public String exportMembers(HttpSession session) throws IOException {
//
//        session.setAttribute("title", "Members");
//
//        ArrayList<MemberEntity> members = _ms.getAllMembers();
//
//        _ios.saveToFile(members, "members");
//
//        return "other/export";
//    }
}
