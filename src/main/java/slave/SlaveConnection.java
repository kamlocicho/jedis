package slave;

import messages.MessageSender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SlaveConnection implements Runnable {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private final String host;
    private final Integer port;
    private MessageSender messageSender;

    public SlaveConnection(String host, String port) {
        if (!validateParams(host, port)) {
            throw new RuntimeException("Invalid replication parameters - expected --replicaof \"<host> <port>\"");
        }
        this.host = host;
        this.port = Integer.parseInt(port);
    }

    @Override
    public void run() {
        initializeConnection();
        validateConnection();
    }

    private void initializeConnection() {
        try {
            client = new Socket(host, port);
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.messageSender = new MessageSender(out, in);
            System.out.println("Connected to master successfully");
        } catch (IOException e) {
            shutdown();
            throw new RuntimeException("Error initializing connection to master");
        }
    }

    private void validateConnection() {
        try {
            messageSender.sendMessage("PING");
            messageSender.sendMessage("REPLCONF");
            messageSender.sendMessage("PSYNC");
        } catch (Exception e) {
            shutdown();
            throw new RuntimeException(e.getMessage());
        }
    }

    private void shutdown() {
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (client != null && !client.isClosed()) {
                client.close();
            }
        } catch (IOException ignored) {
        }
    }

    private boolean validateParams(String host, String port) {
        // TODO: Implement this method in a better way or create utility class
        if (host != null && !host.isEmpty() && port != null && !port.isEmpty()) {
            try {
                Integer.parseInt(port);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
        return false;
    }
}
