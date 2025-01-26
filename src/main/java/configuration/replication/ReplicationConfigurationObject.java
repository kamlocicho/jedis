package configuration.replication;

public class ReplicationConfigurationObject {
    private String role;
    private Integer connectedSlaves;
    private String masterReplicationId;
    private Integer masterReplicationOffset;
    private Integer secondReplicationOffset;
    private Integer replicationBacklogActive;
    private Integer replicationBacklogSize;
    private Integer replicationBacklogFirstByteOffset;

    private Integer replicationBacklogHistlen;

    public String getRole() {
        return role;
    }

    public Integer getConnectedSlaves() {
        return connectedSlaves;
    }

    public String getMasterReplicationId() {
        return masterReplicationId;
    }

    public Integer getMasterReplicationOffset() {
        return masterReplicationOffset;
    }

    public Integer getSecondReplicationOffset() {
        return secondReplicationOffset;
    }

    public Integer getReplicationBacklogActive() {
        return replicationBacklogActive;
    }

    public Integer getReplicationBacklogSize() {
        return replicationBacklogSize;
    }

    public Integer getReplicationBacklogFirstByteOffset() {
        return replicationBacklogFirstByteOffset;
    }

    public Integer getReplicationBacklogHistlen() {
        return replicationBacklogHistlen;
    }

    public static ReplicationConfigurationObject builder() {
        return new ReplicationConfigurationObject();
    }

    public ReplicationConfigurationObject role(String role) {
        this.role = role;
        return this;
    }

    public ReplicationConfigurationObject connectedSlaves(Integer connectedSlaves) {
        this.connectedSlaves = connectedSlaves;
        return this;
    }

    public ReplicationConfigurationObject masterReplicationId(String masterReplicationId) {
        this.masterReplicationId = masterReplicationId;
        return this;
    }

    public ReplicationConfigurationObject masterReplicationOffset(Integer masterReplicationOffset) {
        this.masterReplicationOffset = masterReplicationOffset;
        return this;
    }

    public ReplicationConfigurationObject secondReplicationOffset(Integer secondReplicationOffset) {
        this.secondReplicationOffset = secondReplicationOffset;
        return this;
    }

    public ReplicationConfigurationObject replicationBacklogActive(Integer replicationBacklogActive) {
        this.replicationBacklogActive = replicationBacklogActive;
        return this;
    }

    public ReplicationConfigurationObject replicationBacklogSize(Integer replicationBacklogSize) {
        this.replicationBacklogSize = replicationBacklogSize;
        return this;
    }

    public ReplicationConfigurationObject replicationBacklogFirstByteOffset(Integer replicationBacklogFirstByteOffset) {
        this.replicationBacklogFirstByteOffset = replicationBacklogFirstByteOffset;
        return this;
    }

    public ReplicationConfigurationObject replicationBacklogHistlen(Integer replicationBacklogHistlen) {
        this.replicationBacklogHistlen = replicationBacklogHistlen;
        return this;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setConnectedSlaves(Integer connectedSlaves) {
        this.connectedSlaves = connectedSlaves;
    }

    public void setMasterReplicationId(String masterReplicationId) {
        this.masterReplicationId = masterReplicationId;
    }

    public void setMasterReplicationOffset(Integer masterReplicationOffset) {
        this.masterReplicationOffset = masterReplicationOffset;
    }

    public void setSecondReplicationOffset(Integer secondReplicationOffset) {
        this.secondReplicationOffset = secondReplicationOffset;
    }

    public void setReplicationBacklogActive(Integer replicationBacklogActive) {
        this.replicationBacklogActive = replicationBacklogActive;
    }

    public void setReplicationBacklogSize(Integer replicationBacklogSize) {
        this.replicationBacklogSize = replicationBacklogSize;
    }

    public void setReplicationBacklogFirstByteOffset(Integer replicationBacklogFirstByteOffset) {
        this.replicationBacklogFirstByteOffset = replicationBacklogFirstByteOffset;
    }

    public void setReplicationBacklogHistlen(Integer replicationBacklogHistlen) {
        this.replicationBacklogHistlen = replicationBacklogHistlen;
    }
}
