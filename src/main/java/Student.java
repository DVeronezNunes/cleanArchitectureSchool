import java.util.ArrayList;
import java.util.List;

public class Student {

    //Entity (Can be distinguished from other instances using the CPF)
    private CPF cpf;
    private String name;

    private Email email;
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public void addPhoneNumber(String PhoneNumber, String PhoneCode){
        this.phoneNumbers.add(new PhoneNumber(PhoneNumber, PhoneCode));
    }
}
