package messages.impl;

import messages.Message;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class PingMessage implements Message {
    @Override
    public void sendMessage(PrintWriter out, BufferedReader in) {
        out.println("PING");
        boolean pingSuccess = false;
        for (int i = 0; i < 5; i++) {
            try {
                String response = in.readLine();
                if (response != null && response.equals("+PONG")) {
                    System.out.println("Handshake successful");
                    pingSuccess = true;
                    break;
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException("Error during handshake " + e.getMessage());
            }
        }
        if (!pingSuccess) {
            throw new RuntimeException("Handshake failed");
        }
    }
}
