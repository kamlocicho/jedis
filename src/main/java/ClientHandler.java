import command.Command;
import command.CommandFactory;

import java.io.*;
import java.net.Socket;


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
                Command command = CommandFactory.createCommand(line);
                command.execute(outputStream);
            }
        } catch (IOException e) { // Connection-specific exception
            System.out.println("IOException: " + e.getMessage());
        }
    }
}