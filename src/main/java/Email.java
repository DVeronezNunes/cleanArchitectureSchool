public class Email {

    //Value Object (Can't be distinguished from other instances)
    private String emailAdress;

    public Email(String emailAdress) {
        if (emailAdress == null || !emailAdress.matches("[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            throw new IllegalArgumentException("Invalid email adress");
        }
        this.emailAdress = emailAdress;
    }

}

