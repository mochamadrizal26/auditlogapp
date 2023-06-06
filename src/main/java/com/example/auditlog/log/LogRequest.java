package com.example.auditlog.log;

import java.util.Date;

public record LogRequest(
        String sourceId,
        String producer,
        String action,
        String entityType,
        Date timestamp,
        String userId,
        String message,
        String authData) {
}
