package com.insider.travel.japan.wabisabi.serverlib.domain.dao;

import com.insider.travel.japan.wabisabi.serverlib.domain.model.Mutex;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

/**
 *
 * 
 *
 */

@Dependent
public class MutexDao extends AbstractCommonDao<Mutex> {

    public MutexDao() {
        super.setEntityClass(Mutex.class);
    }

    public Mutex findByIdAccountWrite(int id) {
        return (Mutex) em.createNamedQuery("Mutex.findById", Mutex.class)
                .setParameter("id", id)
                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                .setHint("javax.persistence.query.timeout", 30000)
                .getSingleResult();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
