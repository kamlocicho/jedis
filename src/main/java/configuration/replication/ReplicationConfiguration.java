package configuration.replication;

public class ReplicationConfiguration {
    private static ReplicationConfigurationObject replicationConfigurationObject;

    public static ReplicationConfigurationObject getInstance() {
        synchronized (ReplicationConfiguration.class) {
            if (replicationConfigurationObject == null) {
                replicationConfigurationObject = initializeConfig();
            }
        }
        return replicationConfigurationObject;
    }

    private static ReplicationConfigurationObject initializeConfig() {
        return ReplicationConfigurationObject.builder()
                .role("master")
                .connectedSlaves(0)
                .masterReplicationId("8371b4fb1155b71f4a04d3e1bc3e18c4a990aeeb")
                .masterReplicationOffset(0)
                .secondReplicationOffset(0)
                .replicationBacklogActive(0)
                .replicationBacklogSize(1048576)
                .replicationBacklogFirstByteOffset(0)
                .replicationBacklogHistlen(0);
    }


}
