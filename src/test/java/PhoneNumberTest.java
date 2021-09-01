import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {

    @Test
    void shouldNotBeAcceptAWholePhoneNumberNull(){
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber(null, null));
    }

    @Test
    void shouldNotBeAcceptAWholePhoneNumberEmpty(){
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("", ""));
    }

    @Test
    void shouldNotBeAcceptAPhoneNumberEmpty(){
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("", "11"));
    }

    @Test
    void shouldNotBeAcceptAPhoneNumberNull(){
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber(null, "11"));
    }

    @Test
    void shouldNotBeAcceptAPhoneCodeEmpty(){
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("12345678", ""));
    }

    @Test
    void shouldNotBeAcceptAPhoneCodeNull(){
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("12345678", null));
    }

    @Test
    void shouldNotBeAcceptAPhoneCodeWithJustOneNumber(){
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("12345678", "1"));
    }

    @Test
    void shouldNotBeAcceptAPhoneNumberWithLessThanEigthNumbers(){
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("123", "1"));
    }

    @Test
    void shouldBeAcceptAPhoneNumberValid(){
        assertDoesNotThrow(() -> new PhoneNumber("12345678", "12"));
    }

    @Test
    void theInputedValuesShouldNotBeChanged(){
        String validPhoneCode = "11";
        String validPhoneNumber = "12345678";

        PhoneNumber number = new PhoneNumber(validPhoneCode, validPhoneNumber);
        assertEquals(validPhoneCode, number.getPhoneCode());
        assertEquals(validPhoneNumber, number.getPhoneNumber());
    }
}
