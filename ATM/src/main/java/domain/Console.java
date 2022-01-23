package domain;

import java.util.Scanner;

public class Console {
    /*
    This is an example Console for integration testing
    I have excluded cases of changing printout sentences
     */

    public Console() {
    }



    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e) {
        }
    }


    public void greetings() {
        System.out.println("Welcome to ATM service");
        System.out.println("Please insert a card");
    }

    public void show(String string) {
        clearConsole();
        System.out.println(string);
    }


    public int readOptions() throws Cancellation{
        Scanner sc = new Scanner(System.in);
        clearConsole();
        System.out.println("Please enter a number to use next options[Balance: 1, Deposit: 2, Withdraw: 3  :");
        String input = sc.nextLine();
        if (input == null) throw  new Cancellation();
        else return Integer.parseInt(input) - 1;
    }

    public int readPrompt(String str) throws Cancellation {
        Scanner sc = new Scanner(System.in);
        clearConsole();
        System.out.println(str);
        String input = sc.nextLine();
        if (input == null) throw new Cancellation();
        else return Integer.parseInt(input);
    }

    public String readPin() throws Cancellation {
        Scanner sc = new Scanner(System.in);
        clearConsole();
        System.out.println("Please enter your PIN numbers: " );
        String input = sc.nextLine();
        clearConsole();
        if (input == null) throw new Cancellation();
        else return input;
    }

    public static class Cancellation extends Exception {
        public Cancellation() {
            super("The action was cancelled");
        }
    }


}
