package school.domainLayer.student;

import java.util.ArrayList;
import java.util.List;

public class Student {

    //Entity (Can be distinguished from other instances using the school.student.CPF)
    private CPF cpf;
    private String name;
    private String password;

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    private Email email;

    public String getCpf() { return cpf.getCPF(); }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getEmailAdress();
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public void addPhoneNumber(String PhoneNumber, String PhoneCode){
        this.phoneNumbers.add(new PhoneNumber(PhoneNumber, PhoneCode));
    }
}
