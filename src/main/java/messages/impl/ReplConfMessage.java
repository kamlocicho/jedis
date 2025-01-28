package messages.impl;

import commons.Arguments;
import messages.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReplConfMessage implements Message {
    @Override
    public void sendMessage(PrintWriter out, BufferedReader in) {
        try {
            String message = "REPLCONF listening " + Arguments.getArgument("port");
            System.out.println(message);
            out.println(message);
            String response = in.readLine();
            if (response != null) {
                System.out.println(response);
            }
            message = "REPLCONF capa psync2";
            System.out.println(message);
            out.println(message);
            response = in.readLine();
            if (response != null) {
                System.out.println(response);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error sending REPLCONF message", e);
        }
    }
}
