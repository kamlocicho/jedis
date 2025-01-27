package configuration.replication;

import commons.Arguments;
import commons.ReplicationIdGenerator;

public class ReplicationConfiguration {
    private static volatile ReplicationConfigurationObject replicationConfigurationObject;

    public static ReplicationConfigurationObject getInstance() {
        if (replicationConfigurationObject == null) {
            synchronized (ReplicationConfiguration.class) {
                if (replicationConfigurationObject == null) {
                    replicationConfigurationObject = initializeConfig();
                }
            }
        }
        return replicationConfigurationObject;
    }

    private static ReplicationConfigurationObject initializeConfig() {
        String role = Arguments.hasArgument("replicaof") ? "slave" : "master";
        String masterReplicationId = "master".equals(role) ? ReplicationIdGenerator.generate() : "";
        return ReplicationConfigurationObject.builder()
                .role(role)
                .connectedSlaves(0)
                .masterReplicationId(masterReplicationId)
                .masterReplicationOffset(0)
                .secondReplicationOffset(0)
                .replicationBacklogActive(0)
                .replicationBacklogSize(1048576)
                .replicationBacklogFirstByteOffset(0)
                .replicationBacklogHistlen(0);
    }


}
