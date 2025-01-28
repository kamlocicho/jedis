package messages.impl;

import configuration.replication.ReplicationConfiguration;
import messages.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class PsyconfMessage implements Message {
    @Override
    public void sendMessage(PrintWriter out, BufferedReader in) {
        String replicationId = ReplicationConfiguration.getInstance().getMasterReplicationId();
        Integer replicationOffset = ReplicationConfiguration.getInstance().getMasterReplicationOffset();
        String message = "PSYNC " + replicationId + " " + replicationOffset;
        System.out.println(message);
        out.println(message);

        String response;
        try {
            response = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error reading response from master");
        }
        System.out.println(response);
    }
}
