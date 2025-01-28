package messages;

import java.io.BufferedReader;
import java.io.PrintWriter;

public interface Message {
    void sendMessage(PrintWriter out, BufferedReader in);
}
