package messages;

import messages.impl.PingMessage;
import messages.impl.PsyconfMessage;
import messages.impl.ReplConfMessage;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class MessageSender {
    private final PrintWriter out;
    private final BufferedReader in;

    public MessageSender(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    // data parameter is optional and used only in some cases
    public void sendMessage(String messageName) {
        sendMessage(messageName, null);
    }

    // This way logic of validating response and sending message is extracted into every single message class
    public void sendMessage(String messageName, Object data) {
        Message message;
        if (messageName.equals("PING")) {
            message = new PingMessage();
        } else if (messageName.equals("REPLCONF")) {
            message = new ReplConfMessage();
        } else if (messageName.equals("PSYNC")) {
            message = new PsyconfMessage();
        } else {
            throw new RuntimeException("Invalid message type");
        }
        message.sendMessage(out, in);
    }
}
