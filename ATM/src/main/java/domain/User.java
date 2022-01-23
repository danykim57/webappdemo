package domain;

import java.util.ArrayList;

public class User {
    private int uid;
    private ArrayList<Account> accounts;

    public User(int uid, ArrayList<Account> accounts) {
        this.uid = uid;
        this.accounts = accounts;
    }

    public int getUid() {
        return uid;
    }

    public Account getAccounts(int accountNum) {
        return accounts.get(accountNum);
    }

}
