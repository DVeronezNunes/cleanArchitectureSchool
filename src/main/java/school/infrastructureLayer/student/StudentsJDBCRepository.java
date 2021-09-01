package school.infrastructureLayer.student;

import school.domainLayer.student.CPF;
import school.domainLayer.student.PhoneNumber;
import school.domainLayer.student.Student;
import school.domainLayer.student.StudentsRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentsJDBCRepository implements StudentsRepository {

    private Connection connection;

    public StudentsJDBCRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enroll(Student student) {
        String insertStudent = "INSERT INTO STUDENT VALUES (?,?,?)";
        String insertPhone = "INSERT INTO PHONENUMBER VALUES (?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(insertStudent);
            ps.setString(1, student.getCpf());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.execute();

            ps = connection.prepareStatement(insertPhone);

          for(PhoneNumber phoneNumber: student.getPhoneNumbers()){
              ps.setString(1, phoneNumber.getPhoneCode());
              ps.setString(2,phoneNumber.getPhoneNumber());
              ps.execute();
          }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student searchByCPF(CPF cpf) {
        return null;
    }

    @Override
    public List<Student> listAllEnrolledStudents() {
        return null;
    }
}
