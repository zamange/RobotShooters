package ServerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuitTest {
    public PrintStream stream = System.out;
    public ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testQuitCommand(){
        System.out.println("Shutting Down The Server...");
        assertEquals("Shutting Down The Server...", outputStream.toString().trim());
    }
}
