public class CPF {

    //Value Object (Can't be distinguished from other instances)
    private String CPF;

    public CPF(String CPF) {
        if (CPF == null || !CPF.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
            throw new IllegalArgumentException("Invalid CPF");
        }
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }
}
