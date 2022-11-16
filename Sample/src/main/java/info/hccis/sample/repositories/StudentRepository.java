package info.hccis.sample.repositories;

import info.hccis.sample.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Simple repository for database interaction
 *
 * @author Fred Campos/CIS2232
 * @since 2021-10-14
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

        Student findByStudentId(int id);
        Student findByName(String name);
        Student findByProgram(String program);
    
}