package school.infrastructureLayer.student;

import school.domainLayer.student.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncoderMD5 implements PasswordEncoder {
    @Override
    public String encodePassword(String password) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating hashß");
        }
    }

    @Override
    public boolean checkPassword(String password, String encodedPassword) {
        return encodedPassword.equals(encodePassword(password));
    }
}
