package school.applicationLayer.student.enroll;

import school.domainLayer.student.Student;
import school.domainLayer.student.StudentsRepository;

public class EnrollStudent {
    // Usecase
    private final StudentsRepository repository;

    public EnrollStudent(StudentsRepository repository) {
        this.repository = repository;
    }

    public void execute (EnrollStudentDTO data) {
        Student newStudent = data.createStudent();
        repository.enroll(newStudent);
    }
}
