package school.applicationLayer.student.enroll;

import school.domainLayer.student.CPF;
import school.domainLayer.student.Email;
import school.domainLayer.student.Student;

public class EnrollStudentDTO {
    private String studentName;
    private String studentCPF;
    private String studentEmail;

    public EnrollStudentDTO(String studentName, String studentCPF, String studentEmail ){
        this.studentName = studentName;
        this.studentCPF = studentCPF;
        this.studentEmail = studentEmail;
    }


    public Student createStudent() {
        return new Student(new CPF(studentCPF),studentName,new Email(studentEmail));
    }
}
