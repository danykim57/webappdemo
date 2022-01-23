package transactions;

import bank.Bank;
import devices.CardReader;
import devices.CashBin;
import domain.ATM;
import domain.Account;
import domain.Card;
import domain.Console;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import services.ATMService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepositTest {
    @Mock
    ATM atm;

    Console console = new Console();

    Account account = new Account("Name", 1, 100);
    Card card = new Card();
    Deposit deposit = new Deposit(atm, account, card, "pin");

    @Mock
    Bank bank;
    @Mock
    CardReader cardReader;
    @Mock
    CashBin cashBin;

    @Test
    void doTransactionTest() throws Console.Cancellation {
        ATMService atmService = new ATMService(atm, bank, cardReader, cashBin);
        int amount = deposit.doTransaction(atmService);
        assertEquals(amount, deposit.doTransaction(atmService));
        assertNotNull(atmService);
    }
}