package school.infrastructureLayer.student;

import school.domainLayer.student.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
       String selectByCPF = "SELECT id, name, email FROM STUDENT WHERE cpf = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(selectByCPF);
            ps.setString(1, cpf.getCPF());

            ResultSet rs = ps.executeQuery();
            boolean found = rs.next();

            if(!found){
                throw new StudentNotFound( cpf);
            }

            String name = rs.getString("name");
            String email = rs.getString("email");

            FactoryStudent factoryStudentFound = new FactoryStudent();
            factoryStudentFound.withNameCPFandEmail(name, cpf.getCPF(), email)
            .create();

            Long id = rs.getLong("id");

            String selectPhoneByCPF = "SELECT phoneCode, phoneNumber FROM PHONES WHERE studentId = ?";
            ps = connection.prepareStatement(selectPhoneByCPF);
            ps.setLong(1, id);
            rs = ps.executeQuery(selectPhoneByCPF);

            while (rs.next()){
                String phoneCode = rs.getString("phoneCode");
                String phoneNumber = rs.getString("phoneNumber");
                factoryStudentFound.withPhoneNumber(phoneCode, phoneNumber);
                factoryStudentFound.create();
            }

            return factoryStudentFound.create();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Student> listAllEnrolledStudents() {
        String selectAllStudents = "SELECT id, cpf, name, email FROM STUDENT";
        String selectPhoneAllStudents = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(selectAllStudents);
            ResultSet rs = ps.executeQuery();
            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String nome = rs.getString("nome");
                Email email = new Email(rs.getString("email"));
                Student student = new Student(cpf, nome, email);

                Long id = rs.getLong("id");

                PreparedStatement psTelefone = connection.prepareStatement(selectPhoneAllStudents);
                psTelefone.setLong(1, id);
                ResultSet rsTelefone = psTelefone.executeQuery();
                while (rsTelefone.next()) {
                    String numero = rsTelefone.getString("numero");
                    String ddd = rsTelefone.getString("ddd");
                    student.addPhoneNumber(ddd, numero);
                }

                students.add(student);
            }

            return students;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
