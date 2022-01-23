package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    //For Simplification, I did not consider invalid input

    Card card = new Card("0000-0000-0000-0000");
    @Test
    void getCardNumbers() {
        assertEquals("0000-0000-0000-0000", card.getCardNumbers());
    }

    @Test
    void setCardNumbers() {
        card.setCardNumbers("1111-1111-1111-1111");
        assertEquals("1111-1111-1111-1111", card.getCardNumbers());
    }
}