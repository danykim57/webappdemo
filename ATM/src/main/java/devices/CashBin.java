package devices;

public interface CashBin {
    boolean checkStoredAmount(int amount); //Check cash bin space to put in money;

    void performDeposit(); //Physically putting in money to cashbin
}
