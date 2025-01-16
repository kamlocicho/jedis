package command.impl;

import command.Command;
import storage.Storage;

import java.io.IOException;
import java.io.OutputStream;

public class GetCommand implements Command {
    private final String[] values;
    public GetCommand(String[] values) {
        this.values = values;
    }

    @Override
    public void execute(OutputStream outputStream) throws IOException {
        Storage storage = Storage.getInstance();
        String value = storage.get(values[0]);
        if (value != null) {
            outputStream.write(value.getBytes());
            outputStream.write("\n".getBytes());
            return;
        }
        outputStream.write("null".getBytes());
        outputStream.write("\n".getBytes());
    }
}
