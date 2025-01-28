package command.impl;

import command.Command;
import configuration.replication.ReplicationConfiguration;

import java.io.IOException;
import java.io.OutputStream;

public class PsyncCommand implements Command {
    String[] values;

    public PsyncCommand(String[] values) {
        this.values = values;
    }

    @Override
    public void execute(OutputStream outputStream) throws IOException {
        String replId = ReplicationConfiguration.getInstance().getMasterReplicationId();
        String response = "+FULLRESYNC " + replId + " 0\n";
        outputStream.write(response.getBytes());
    }
}
