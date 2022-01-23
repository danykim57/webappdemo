package domain;

import java.util.ArrayList;

public class Account {
    private String name;
    private Integer id;
    private int balance;

    public Account(String name, Integer id, int balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
