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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class WithdrawTest {

    ATM atm = new ATM(1);
    Account account = new Account("Name", 1, 100);
    Card card = new Card();
    Withdraw withdraw = new Withdraw(atm, account, card, "pin");

    @Mock
    Bank bank;
    @Mock
    CardReader cardReader;
    @Mock
    CashBin cashBin;

    @Test
    void doTransaction() throws Console.Cancellation {
        ATMService atmService = new ATMService(atm, bank, cardReader, cashBin);
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(result);
        PrintStream original = System.out;
        System.setOut(output);
        String init = result.toString();
        int amount = withdraw.doTransaction(atmService);
        assertNotEquals(init + Integer.toString(amount), result.toString());
        //This shouldn't be equal out of using different System.out
        System.out.flush();
        System.setOut(original);
    }
}