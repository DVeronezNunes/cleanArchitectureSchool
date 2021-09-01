public class PhoneNumber {

    //Value Object (Can't be distinguished from other instances)
    private String PhoneNumber;
    private String PhoneCode;

    public PhoneNumber (String PhoneNumber, String PhoneCode) {
        if ((PhoneNumber == null || PhoneNumber.length() < 7) || (PhoneCode == null || PhoneCode.length() != 2)){
            throw new IllegalArgumentException("Invalid PhoneNumber");
        }
        this.PhoneNumber = PhoneNumber;
        this.PhoneCode = PhoneCode;
    }
}
