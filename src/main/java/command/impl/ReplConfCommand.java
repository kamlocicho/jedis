package command.impl;

import command.Command;

import java.io.IOException;
import java.io.OutputStream;

public class ReplConfCommand implements Command {
    private final String[] values;
    public ReplConfCommand(String[] values) {
        this.values = values;
    }
    @Override
    public void execute(OutputStream outputStream) throws IOException {
        outputStream.write("OK\n".getBytes());
    }
}
