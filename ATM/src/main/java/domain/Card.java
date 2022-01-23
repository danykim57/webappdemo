package domain;

public class Card {
    private String numbers; //Card number

    public Card() {
        this.numbers = null;
    }

    public Card(String numbers) {
        this.numbers = numbers;
    }

    public String getCardNumbers() {
        return numbers;
    }

    public void setCardNumbers(String numbers) {
        this.numbers = numbers;
    }
}
