package school.domainLayer.student;

import java.util.ArrayList;
import java.util.List;

public class Student {

    //Entity (Can be distinguished from other instances using the school.student.CPF)
    private CPF cpf;
    private String name;

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    private Email email;

    public CPF getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public void addPhoneNumber(String PhoneNumber, String PhoneCode){
        this.phoneNumbers.add(new PhoneNumber(PhoneNumber, PhoneCode));
    }
}
