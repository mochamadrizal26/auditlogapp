package com.example.auditlog.log;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class LogJPADataAccessService implements LogDao{

    private final LogRepository logRepository;

    public LogJPADataAccessService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<Log> selectAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public Optional<Log> selectLogById(Integer id) {
        return logRepository.findById(id);
    }

    @Override
    public void insertLog(Log log) {
        logRepository.save(log);
    }
}
