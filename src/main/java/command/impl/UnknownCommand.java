package command.impl;

import command.Command;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class UnknownCommand implements Command {
    @Override
    public void execute(OutputStream outputStream) throws IOException {
        outputStream.write("null\r\n".getBytes(StandardCharsets.UTF_8));
    }
}
