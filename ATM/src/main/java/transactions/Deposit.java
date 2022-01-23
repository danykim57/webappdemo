package transactions;

import domain.ATM;
import domain.Account;
import domain.Card;
import domain.Console;
import services.ATMService;

public class Deposit extends Transaction {
    public Deposit(ATM atm, Account account, Card card, String pin) {
        super(atm, account, card, pin);
    }

    @Override
    public int doTransaction(ATMService atmService) throws Console.Cancellation {
        int amount;
        amount = atm.getConsole().readPrompt("Enter amount to deposit: ");
        if (atmService.getCashBin().checkStoredAmount(amount)) {
            account.setBalance(account.getBalance() + amount);
            atmService.getBank().sendEditedAmount();
            atmService.getCashBin().performDeposit();
            atm.getConsole().show("Deposit is done.");
        }
        else atm.getConsole().show("Unable to continue the deposit run out of space for cash.");
        return this.account.getBalance();
    }
}
