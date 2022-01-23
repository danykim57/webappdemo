package services;

import bank.Bank;
import devices.CardReader;
import devices.CashBin;
import domain.ATM;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ATMServiceTest {

    ATM atm = new ATM(1);

    @Mock
    Bank bank;

    @Mock
    CardReader cardReader;

    @Mock
    CashBin cashbin;

    @Test
    void runATMService() {
        ATMService atmService = new ATMService(atm, bank, cardReader, cashbin);
        assertNotNull(atmService);
    }

    //Should write more integration tests

}