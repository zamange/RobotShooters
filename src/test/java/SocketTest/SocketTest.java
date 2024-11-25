package SocketTest;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SocketTest {
    private final Socket socket = new Socket();
    private SocketTest socketCreated;

    public static ServerSocket createServerSocket(int port) throws IOException {
        return new ServerSocket(port);
    }

    @Test
    public void testServerSocket() throws IOException {
        final int port =1234;
        ServerSocket serverSocketCreated = socketCreated.createServerSocket(port);
        assertEquals(serverSocketCreated.getLocalPort(), port);
    }
}
