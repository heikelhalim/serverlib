package com.insider.travel.japan.wabisabi.serverlib.domain.dao;

import com.insider.travel.japan.wabisabi.serverlib.domain.model.AdminAccountPasswordHistory;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * 
 */
@Dependent
public class AdminAccountPasswordHistoryDao extends AbstractCommonDao<AdminAccountPasswordHistory> {
    
    @Transactional
    @Override
    public AdminAccountPasswordHistory create(AdminAccountPasswordHistory entity) {
        return super.create(entity);
    }

    public List<AdminAccountPasswordHistory> findLatest4ById(String id) {
        return (List<AdminAccountPasswordHistory>) em.createNamedQuery("AdminAccountPasswordHistory.findById", AdminAccountPasswordHistory.class)
            .setParameter("id", id).setFirstResult(0).setMaxResults(4).getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
