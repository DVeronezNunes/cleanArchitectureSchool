public class Email {

    private String emailAdress;

    public Email(String emailAdress) {
        if (emailAdress == null || emailAdress.matches("[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$")){

        }
        this.emailAdress = emailAdress;
    }

}

