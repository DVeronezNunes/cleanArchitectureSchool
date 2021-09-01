package school;

import school.applicationLayer.student.enroll.EnrollStudent;
import school.applicationLayer.student.enroll.EnrollStudentDTO;
import school.infrastructureLayer.student.RepositoryStudentsOnMemory;


public class EnrollNewStudent {
    public static void main(String[] args) {
        String name = "Diego";
        String cpf = "123.456.789-10";
        String email = "test@test.com";

        EnrollStudent enroll = new EnrollStudent(new RepositoryStudentsOnMemory());
        enroll.execute(new EnrollStudentDTO( name,
                                            cpf,
                                            email));
    }
}
