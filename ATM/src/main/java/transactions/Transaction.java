package transactions;

import domain.ATM;
import domain.Account;
import domain.Card;
import domain.Console;
import services.ATMService;

public abstract class Transaction {
    protected static ATM atm;
    protected Account account;
    protected Card card;
    protected String pin;

    protected Transaction(ATM atm, Account account, Card card, String pin) {
        this.atm = atm;
        this.account = account;
        this.card = card;
        this.pin = pin;
    }

    public static Transaction initiateTransaction(Account account, Card card, String pin) throws Console.Cancellation {
        int option = atm.getConsole().readOptions();
        switch (option) {
            case 0:
                return new Balance(atm, account, card, pin);

            case 1:
                return new Deposit(atm, account, card, pin);

            case 2:
                return new Withdraw(atm, account, card, pin);
            default:
                return null; //dummy value
        }
    }

    public abstract int doTransaction(ATMService atmService) throws Console.Cancellation;

}
