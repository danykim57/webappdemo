package transactions;

import domain.ATM;
import domain.Account;
import domain.Card;
import services.ATMService;

public class Balance extends Transaction {
    public Balance(ATM atm, Account account, Card card, String pin) {
        super(atm, account, card, pin);
    }

    @Override
    public int doTransaction(ATMService atmService) {
        atm.getConsole().show(Integer.toString(this.account.getBalance()));
        return this.account.getBalance();
    }
}
