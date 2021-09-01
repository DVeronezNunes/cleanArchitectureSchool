public class PhoneNumber {

    //Value Object (Can't be distinguished from other instances)
    private String PhoneNumber;
    private String PhoneCode;

    public PhoneNumber (String PhoneNumber, String PhoneCode) {

        if (PhoneNumber == null || PhoneCode == null){
            throw new IllegalArgumentException("Phone Code and PhoneNumber are required");
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
