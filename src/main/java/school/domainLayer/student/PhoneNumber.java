package school.domainLayer.student;

public class PhoneNumber {

    //Value Object (Can't be distinguished from other instances)
    private String PhoneNumber;
    private String PhoneCode;

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getPhoneCode() {
        return PhoneCode;
    }

    public PhoneNumber (String PhoneCode, String PhoneNumber) {

        if (PhoneNumber == null || PhoneCode == null){
            throw new IllegalArgumentException("Phone Code and school.student.PhoneNumber are required");
        }

        if (!PhoneCode.matches("\\d{2}")){
            throw new IllegalArgumentException("Invalid Phone Code");
        }

        if (!PhoneNumber.matches("\\d{8}|\\d{9}")){
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        this.PhoneNumber = PhoneNumber;
        this.PhoneCode = PhoneCode;
    }
}
