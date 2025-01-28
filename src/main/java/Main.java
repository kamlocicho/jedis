import commons.Arguments;
import slave.SlaveConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    @SuppressWarnings("java:S2189")
    public static void main(String[] args) {
        Arguments.parseArguments(args);
        if (Arguments.hasArgument("replicaof")) {
            if (!Arguments.hasArgument("port")) {
                throw new RuntimeException("Missing port argument");
            }
            String[] data = Arguments.getArgument("replicaof").split(" ");
            SlaveConnection slaveConnection = new SlaveConnection(data[0], data[1]);
            Thread.ofVirtual().start(slaveConnection);
        }
        int port = (Arguments.hasArgument("port")) ? Integer.parseInt(Arguments.getArgument("port")) : 6379;
        System.out.println("Starting server on port " + port);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReuseAddress(true);
            for (;;) {
                Socket clientSocket = serverSocket.accept();
                Thread.ofVirtual().start(new ClientHandler(clientSocket));
            }
        } catch (IOException e) { // Server-level exception
            System.out.println("IOException: " + e.getMessage());
        }
    }
}