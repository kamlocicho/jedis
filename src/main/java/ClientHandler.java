import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (socket;
             OutputStream outputStream = socket.getOutputStream();
             InputStream inputStream = socket.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equalsIgnoreCase("PING")) { // Check if command is "PING"
                    outputStream.write("+PONG\r\n".getBytes(StandardCharsets.UTF_8));
                }
            }
        } catch (IOException e) { // Connection-specific exception
            System.out.println("IOException: " + e.getMessage());
        }
    }
}