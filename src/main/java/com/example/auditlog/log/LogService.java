package com.example.auditlog.log;

import com.example.auditlog.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private final LogDao logDao;

    public LogService(@Qualifier("jpa") LogDao logDao) {
        this.logDao = logDao;
    }
    public List<Log> getAllLogs(){
        return logDao.selectAllLogs();
    }

    public Log getLog(Integer id){
        return logDao.selectLogById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "data with id [%s] not found".formatted(id)));
    }

    public void addLog(
            LogRequest logRequest){
        Log log = new Log(
                logRequest.sourceId(),
                logRequest.producer(),
                logRequest.action(),
                logRequest.entityType(),
                logRequest.timestamp(),
                logRequest.userId(),
                logRequest.message(),
                logRequest.authData()
        );
        logDao.insertLog(log);
    }

    public List<Integer> getAllIds(){
        return logDao.selectAllIds();
    }

    public void deleteAllLogs(){
        logDao.deleteAllLogs();
    }

    public void deleteLogById(Integer id){
        logDao.deleteLogById(id);
    }

}
