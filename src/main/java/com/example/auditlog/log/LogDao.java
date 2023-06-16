package com.example.auditlog.log;

import java.util.List;
import java.util.Optional;

public interface LogDao {
    List<Log> selectAllLogs();
    Optional<Log> selectLogById(Integer id);
    void insertLog(Log log);
    List<Integer> selectAllIds();
    void deleteAllLogs();
    void deleteLogById(Integer id);
}
