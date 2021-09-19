package school.domainLayer.student;

import java.util.List;

public interface StudentsRepository {

    void enroll(Student student);

    Student searchByCPF(CPF cpf);

    List<Student> listAllEnrolledStudents();
}
