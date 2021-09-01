import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldNotBeAcceptAnEmailNull(){
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
    }

    @Test
    void shouldNotBeAcceptAnEmailWithoutAtSign(){
        assertThrows(IllegalArgumentException.class, () -> new Email("test.com"));
    }

    @Test
    void shouldNotBeAcceptAnEmailWithoutDotCom(){
        assertThrows(IllegalArgumentException.class, () -> new Email("test@.br"));
    }

    @Test
    void shouldBeAcceptACPFValid(){
        assertDoesNotThrow(() -> new Email("test@test.com"));
    }
}
