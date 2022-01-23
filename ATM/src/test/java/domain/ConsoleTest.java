package domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {
    Console console = new Console();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream cur = new PrintStream(baos);

    @Test
    void clearConsole() {
        PrintStream old = System.out;
        System.setOut(cur);
        System.out.println("Ha Ha ");
        console.clearConsole();
        System.setOut(old);
        String str = baos.toString();
        assertEquals(str, "");
    }

    @Test
    void greetings() {
        PrintStream old = System.out;
        System.setOut(cur);
        console.greetings();
        System.out.flush();
        System.setOut(old);
        String str = baos.toString();
        assertTrue(str.contains("Welcome to ATM service"));
    }

    @Test
    void show() {
    }

    @Test
    void readOptions() {
    }

    @Test
    void readPrompt() {
    }

    @Test
    void readPin() {
    }
}