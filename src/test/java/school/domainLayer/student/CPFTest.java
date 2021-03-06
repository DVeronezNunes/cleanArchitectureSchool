package school.domainLayer.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    void shouldNotBeAcceptACPFNull(){
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
    }

    @Test
    void shouldNotBeAcceptACPFEmpty(){
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
    }

    @Test
    void shouldBeAcceptACPFValid(){
        assertDoesNotThrow(() -> new CPF("123.456.789-10"));
    }

    @Test
    void theInputedValueShouldNotBeChanged(){
        String validCPF = "123.456.789-10";

        CPF number = new CPF(validCPF);
        assertEquals(validCPF, number.getCPF());
    }
}
