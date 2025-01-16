package command.impl;

import command.Command;

import java.io.IOException;
import java.io.OutputStream;

public class EchoCommand implements Command {
    private final String[] values;

    public EchoCommand(String[] values) {
        this.values = values;
    }

    @Override
    public void execute(OutputStream outputStream) throws IOException {
        for (String value : values) {
            outputStream.write(value.getBytes());
            outputStream.write(" ".getBytes());
        }
        outputStream.write("\n".getBytes());
    }
}
