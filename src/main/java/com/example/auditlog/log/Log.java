package com.example.auditlog.log;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Log {

    @Id
    @SequenceGenerator(
            name = "id_sequence",
            sequenceName =  "id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_sequence"
    )
    private Integer id;

    @Column(length = 20)
    private String sourceId;

    @Column(length = 10)
    private String producer;

    @Column(length = 50)
    private String action;

    @Column(length = 15)
    private String entityType;
    private Date timestamp;

    @Column(length = 50)
    private String userId;

    @Lob
    @Column
    private String message;

    @Lob
    @Column
    private String authData;

    public Log() {
    }

    public Log(Integer id, String sourceId, String producer, String action, String entityType, Date timestamp, String userId, String message, String authData) {
        this.id = id;
        this.sourceId = sourceId;
        this.producer = producer;
        this.action = action;
        this.entityType = entityType;
        this.timestamp = timestamp;
        this.userId = userId;
        this.message = message;
        this.authData = authData;
    }

    public Log(String sourceId, String producer, String action, String entityType, Date timestamp, String userId, String message, String authData) {
        this.sourceId = sourceId;
        this.producer = producer;
        this.action = action;
        this.entityType = entityType;
        this.timestamp = timestamp;
        this.userId = userId;
        this.message = message;
        this.authData = authData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthData() {
        return authData;
    }

    public void setAuthData(String authData) {
        this.authData = authData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(id, log.id) && Objects.equals(sourceId, log.sourceId) && Objects.equals(producer, log.producer) && Objects.equals(action, log.action) && Objects.equals(entityType, log.entityType) && Objects.equals(timestamp, log.timestamp) && Objects.equals(userId, log.userId) && Objects.equals(message, log.message) && Objects.equals(authData, log.authData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceId, producer, action, entityType, timestamp, userId, message, authData);
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", sourceId='" + sourceId + '\'' +
                ", producer='" + producer + '\'' +
                ", action='" + action + '\'' +
                ", entityType='" + entityType + '\'' +
                ", timestamp=" + timestamp +
                ", userId='" + userId + '\'' +
                ", message='" + message + '\'' +
                ", authData='" + authData + '\'' +
                '}';
    }
}
