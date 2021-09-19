package school.domainLayer.student.enroll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import school.applicationLayer.student.enroll.EnrollStudent;
import school.applicationLayer.student.enroll.EnrollStudentDTO;
import school.domainLayer.student.CPF;
import school.domainLayer.student.Student;
import school.infrastructureLayer.student.RepositoryStudentsOnMemory;



public class EnrollStudentTest {

    @Test
    void useCaseExecutedwithSuccess(){
        String name = "Diego";
        String cpf = "123.456.789-10";
        String email = "test@test.com";

        RepositoryStudentsOnMemory repository = new RepositoryStudentsOnMemory();
        EnrollStudent useCase = new EnrollStudent(repository);
        EnrollStudentDTO enrollStudentDTO = new EnrollStudentDTO(name, cpf, email);

        useCase.execute(enrollStudentDTO);

        Student found = repository.searchByCPF(new CPF(cpf));
        assertEquals(name, found.getName());
        assertEquals(cpf, found.getCpf());
        assertEquals(email, found.getEmail());
    }
}
