package school.domainLayer.student;

public class FactoryStudent {

    private Student student;

    public FactoryStudent withNameCPFandEmail(String name,String cpfNumber,String emailAdress){
        CPF cpf = new CPF(cpfNumber);
        Email email = new Email(emailAdress);

        this.student = new Student(cpf, name, email);
        return this;
    }

    public FactoryStudent withPhoneNumber(String phoneCode, String phoneNumber){
        this.student.addPhoneNumber(phoneCode,phoneCode);
        return this;
    }

    public Student create(){
        return this.student;
    }
}
