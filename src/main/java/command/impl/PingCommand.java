package command.impl;

import command.Command;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PingCommand implements Command {
    @Override
    public void execute(OutputStream outputStream) throws IOException {
        outputStream.write("+PONG\r\n".getBytes(StandardCharsets.UTF_8));
    }
}
