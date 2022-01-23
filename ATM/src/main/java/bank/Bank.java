package bank;

import domain.User;

public interface Bank {
    User getAuthorization(String cardNumbers, String pin);

    void sendEditedAmount();
}
