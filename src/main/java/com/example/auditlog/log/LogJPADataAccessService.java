package com.example.auditlog.log;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class LogJPADataAccessService implements LogDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Log> selectAllLogs() {
        return entityManager.createQuery("SELECT log FROM Log log", Log.class)
                .getResultList();
    }

    @Override
    public Optional<Log> selectLogById(Integer id) {
        return Optional.ofNullable(entityManager.find(Log.class, id));
    }

    @Override
    @Transactional
    public void insertLog(Log log) {
        entityManager.persist(log);
    }

    @Override
    public List<Integer> selectAllIds() {
        return entityManager.createQuery("SELECT log.id FROM Log log", Integer.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void deleteAllLogs() {
        entityManager.createQuery("DELETE FROM Log").executeUpdate();
    }

    @Override
    @Transactional
    public void deleteLogById(Integer id) {
        Log log = entityManager.find(Log.class, id);
        if (log != null) {
            entityManager.remove(log);
        }
    }
}