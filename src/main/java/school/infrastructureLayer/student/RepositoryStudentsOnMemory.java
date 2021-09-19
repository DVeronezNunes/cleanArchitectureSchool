package school.infrastructureLayer.student;

import school.domainLayer.student.CPF;
import school.domainLayer.student.Student;
import school.domainLayer.student.StudentNotFound;
import school.domainLayer.student.StudentsRepository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryStudentsOnMemory implements StudentsRepository {

    private List<Student> enrolledStudents = new ArrayList<>();

    @Override
    public void enroll(Student student) {
        this.enrolledStudents.add(student);
    }

    @Override
    public Student searchByCPF(CPF cpf) {
        return this.enrolledStudents
                .stream()
                .filter(cpfNumber -> cpfNumber.getCpf().equals(cpf.getCPF()))
                .findFirst()
                .orElseThrow(() -> new StudentNotFound(cpf));
    }

    @Override
    public List<Student> listAllEnrolledStudents() {
        return this.enrolledStudents;
    }
}
