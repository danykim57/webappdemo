package services;

import bank.Bank;
import devices.CardReader;
import devices.CashBin;
import domain.*;
import transactions.Transaction;

public class ATMService {
    private ATM atm;
    private final Bank bank;
    private final CardReader cardReader;
    private final CashBin cashBin;

    public ATMService(ATM atm, Bank bank, CardReader cardReader, CashBin cashBin) {
        assert bank != null;
        assert cardReader != null;
        assert cashBin != null;
        this.bank = bank;
        this.cardReader = cardReader;
        this.cashBin = cashBin;
    }

    public User verifyAuthorization(String cardNumbers, String pin) {
        User user = bank.getAuthorization(cardNumbers, pin);
        return user;
    }

    public void runATMService() throws Console.Cancellation {
        //Insert Card => PIN number => Select Account => See Balance/Deposit/Withdraw
        ATM atm = new ATM(1);
        Card card = new Card();
        atm.getConsole().show("Please enter a card.");


        while (atm.isCardIn()) {
            card.setCardNumbers(cardReader.readCard());
            if (cardReader.isCardIn()) {
                atm.cardInserted(); //Change card status in ATM to true
            }

            else atm.getConsole().show("Unable to read the card.");
        }

        atm.getConsole().show("Please enter PIN numbers");
        String pin = atm.getConsole().readPin();
        User user = this.verifyAuthorization(card.getCardNumbers(), pin);
        if (user != null) {
            int accountNum = atm.getConsole().readPrompt("Please enter an account number.");
            Transaction currentTransaction = null;
            currentTransaction = Transaction.initiateTransaction(user.getAccounts(accountNum), card, pin);
            currentTransaction.doTransaction(this);
            atm.getConsole().show("Your current balance is: " + user.getAccounts(accountNum).getBalance());
        }
        else atm.getConsole().show("PIN number is not correct. Please check PIN numbers.");
    }

    public ATM getAtm() {
        return atm;
    }

    public Bank getBank() {
        return bank;
    }

    public CardReader getCardReader() {
        return cardReader;
    }

    public CashBin getCashBin() {
        return cashBin;
    }


}
