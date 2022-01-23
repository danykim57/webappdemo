package domain;

import bank.Bank;

public class ATM {
    /**
     * Future updated variables
     * BankSystem, CashBin, CardReader
     */

    private int id;
    private boolean isCardIn;
    private Console console = new Console();
    

    /**
     * @param id This ATM unique id
     */
    public ATM(int id) {
        this.id = id;
        isCardIn = false;
    }

    public int getId() {
        return id;
    }

    public void cardInserted() {
        isCardIn = true;
    }

    public Console getConsole() {
        return console;
    }

    public boolean isCardIn() {
        return isCardIn;
    }

}
