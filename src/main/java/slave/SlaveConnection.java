package slave;

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

    public SlaveConnection(String host, String port) {
        if (!validateParams(host, port)) {
            System.out.println("Invalid parameters");
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
            System.out.println("Connected to master successfully");
        } catch (IOException e) {
            shutdown();
            throw new RuntimeException("Error initializing connection to master");
        }
    }

    private void validateConnection() {
        String message = "*1\r\n$4\r\nPING\r\n";
        out.println(message);

        for (int i = 0; i < 5; i++) {
            try {
                String response = in.readLine();
                if (response != null && response.equals("+PONG")) {
                    System.out.println("Handshake successful");
                    return;
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException("Error during handshake " + e.getMessage());
            }
        }
        throw new RuntimeException("Handshake failed");
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
