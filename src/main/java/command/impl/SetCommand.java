package command.impl;

import command.Command;
import storage.Storage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SetCommand implements Command {
    private final ScheduledExecutorService executorService;
    private String[] values;

    public SetCommand(String[] values) {
        this.values = values;
        executorService = Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void execute(OutputStream outputStream) throws IOException {
        Storage storage = Storage.getInstance();
        if (values.length == 2) {
            storage.set(values[0], values[1]);
            outputStream.write("OK\r\n".getBytes());
            return;
        } else if (values.length == 4 && values[2].equalsIgnoreCase("px")) {
            long milliseconds = Long.parseLong(values[3]);
            // Schedule the removal of the key after the specified time
            executorService.schedule(() -> storage.remove(values[0]), milliseconds, TimeUnit.MILLISECONDS);
            outputStream.write("OK\r\n".getBytes());
            return;
        }
        outputStream.write("ERROR: Bad input\r\n".getBytes());
    }
}
