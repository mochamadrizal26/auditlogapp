package com.example.auditlog.log;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/auditlog")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public List<Log> getLogs(){
        return logService.getAllLogs();
    }

    @GetMapping(path = "{logId}")
    public Log getLog(
            @PathVariable("logId") Integer logId){
        return logService.getLog(logId);
    }

    @PostMapping
    public void insertLog(
            @RequestBody LogRequest request){
        logService.addLog(request);
    }
}
