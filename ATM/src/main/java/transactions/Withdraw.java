package transactions;

import devices.CashBin;
import domain.ATM;
import domain.Account;
import domain.Card;
import domain.Console;
import services.ATMService;

public class Withdraw extends Transaction {

    public Withdraw(ATM atm, Account account, Card card, String pin) {
        super(atm, account, card, pin);
    }
    @Override
    public int doTransaction(ATMService atmService) throws Console.Cancellation {
        int amount;
        boolean isEnoughAmount = false;

        amount = atm.getConsole().readPrompt("Enter an account number: ");
        while (! isEnoughAmount) {
            amount = atm.getConsole().readPrompt("Enter amount to withdraw: ");
            if (atmService.getCashBin().checkStoredAmount(amount)) {
                if (amount <= account.getBalance()) isEnoughAmount = true;
                else atm.getConsole().show("The entered cash amount is not available from the account");
            }
            else atm.getConsole().show("There is not enough money in the cash bin currently.");
        }
        if (isEnoughAmount) {
            account.setBalance(account.getBalance() - amount);
            atm.getConsole().show("Withdraw is done.");
        }
        atm.getConsole().show("Your current balance is: " + account.getBalance());
        return this.account.getBalance();
    }
}
