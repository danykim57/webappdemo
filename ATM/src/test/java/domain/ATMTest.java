package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    ATM atm = new ATM(1);

    @Test
    void getId() {
        assertEquals(1, atm.getId());
    }

    @Test
    void cardInserted() {
        atm.cardInserted();
        assertEquals(true, atm.isCardIn());
    }

    @Test
    void getConsole() {
        Console console = atm.getConsole();
        assertNull(console);
    }

    @Test
    void isCardIn() {
        assertEquals(false, atm.isCardIn());
    }
}