package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account = new Account("savingAccount", 100, 1000);

    @Test
    void getId() {
        assertEquals(100, account.getId());
    }

    @Test
    void getBalance() {
        assertEquals(1000, account.getBalance());
    }

    @Test
    void setBalance() {
        account.setBalance(1000 + 9000);
        assertEquals(10000, account.getBalance());
    }
}