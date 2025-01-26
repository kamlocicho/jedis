package command.impl;

import command.Command;
import commons.Parser;
import configuration.replication.ReplicationConfiguration;

import java.io.OutputStream;

public class InfoCommand implements Command {
    String[] values;

    public InfoCommand(String[] values) {
        this.values = values;
    }

    @Override
    public void execute(OutputStream outputStream) {
        try {
            if (values.length == 0) {
                outputStream.write("Available sections:".getBytes());
                outputStream.write("replication".getBytes());
            } else if ("replication".equals(values[0])) {
                var replicationConfiguration = ReplicationConfiguration.getInstance();
                outputStream.write("Replication configuration:\n".getBytes());
                outputStream.write(Parser.bulkString(replicationConfiguration).getBytes());
            } else {
                outputStream.write("ERROR: Bad input\r\n".getBytes());
            }
        } catch (Exception e) {
            System.out.println("Error writing to output stream: " + e.getMessage());
        }
    }
}
