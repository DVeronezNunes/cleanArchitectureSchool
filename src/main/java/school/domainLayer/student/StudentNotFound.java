package school.domainLayer.student;

public class StudentNotFound extends RuntimeException{

    public StudentNotFound(CPF cpf) {
        super("Not found a student with CPF: " + cpf.getCPF());
    }
}
