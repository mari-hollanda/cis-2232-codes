package info.hccis.sample.rest;

import info.hccis.sample.entity.Student;
import info.hccis.sample.repositories.StudentRepository;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/StudentService/student")
public class StudentService {

    private final StudentRepository _sr;

    @Autowired
    public StudentService(StudentRepository _sr) {
        this._sr = _sr;
    }

    @GET
    @Produces("application/json")
    public ArrayList<Student> getAll() {
        ArrayList<Student> students = (ArrayList<Student>) _sr.findAll();
        return students;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getStudentById(@PathParam("id") int id) throws URISyntaxException {

        Optional<Student> student = _sr.findById(id);

        if (!student.isPresent()) {
            return Response.status(204).build();
        } else {
            return Response
                    .status(200)
                    .entity(student).build();
        }
    }

    @GET
    @Path("/program/{program}")
    @Produces("application/json")
    public ArrayList<Student> getStudentsByProgram(@PathParam("program") String program) {

        ArrayList<Student> students = new ArrayList();
        Student student = _sr.findByProgram(program);
//        Student student = new Student();
//        student.setName(program);
        students.add(student);
        return students;
    }
}
