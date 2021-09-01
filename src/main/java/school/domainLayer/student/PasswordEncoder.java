package school.domainLayer.student;

public interface PasswordEncoder {

    String encodePassword(String password);

    boolean checkPassword(String password, String encodedPassword);
}
