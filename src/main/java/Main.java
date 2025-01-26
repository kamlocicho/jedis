import commons.Arguments;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    @SuppressWarnings("java:S2189")
    public static void main(String[] args) {
        Arguments.parseArguments(args);
        int port = (Arguments.hasArgument("port")) ? Integer.parseInt(Arguments.getArgument("port")) : 6379;
        System.out.println("Starting server on port " + port);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // Since the tester restarts your program quite often, setting
            // SO_REUSEADDR ensures that we don't run into 'Address already in use'
            // errors
            serverSocket.setReuseAddress(true);
            while (true) {
                // Wait for connection from client.
                Socket clientSocket = serverSocket.accept();
                Thread.ofVirtual().start(new ClientHandler(clientSocket));
            }
        } catch (IOException e) { // Server-level exception
            System.out.println("IOException: " + e.getMessage());
        }
    }
}