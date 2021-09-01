import java.util.ArrayList;
import java.util.List;

public class Student {

    //Entity (Can be distinguished from other instances using the CPF)
    private CPF cpf;
    private String name;
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
