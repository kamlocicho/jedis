import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class ClientHandler extends Thread {

    private final OutputStream outputStream;
    private final String command;

    public ClientHandler(OutputStream outputStream, String command) {
        this.outputStream = outputStream;
        this.command = command;
    }

    @Override
    public void run() {
        if (Objects.equals(command, "PING")) {
            System.out.println("Running command");
            String res = "+PONG\r\n";
            try {
                outputStream.write(res.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
