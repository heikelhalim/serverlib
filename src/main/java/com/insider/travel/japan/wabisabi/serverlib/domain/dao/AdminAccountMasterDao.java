package com.insider.travel.japan.wabisabi.serverlib.domain.dao;

import com.insider.travel.japan.wabisabi.serverlib.domain.model.AdminAccountMaster;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;

/**
 *
 * 
 */
@Dependent
public class AdminAccountMasterDao extends AbstractCommonDao<AdminAccountMaster> {
    
    public AdminAccountMasterDao() {
        super.setEntityClass(AdminAccountMaster.class);
    }

    public AdminAccountMaster findOne(String pk) {
        return getEntityManager().find(AdminAccountMaster.class, pk);
    }
    
    public List<AdminAccountMaster> findAll(int startIndex, int maxResults) {
        return (List<AdminAccountMaster>) em.createNamedQuery("AdminAccountMaster.findAll", AdminAccountMaster.class)
                .setFirstResult(startIndex).setMaxResults(maxResults).getResultList();
    }

    public AdminAccountMaster findByEmail(String email) {
        List<AdminAccountMaster> entitiesFound = (List<AdminAccountMaster>) em.createNamedQuery("AdminAccountMaster.findByEmail", AdminAccountMaster.class)
            .setParameter("email", email).getResultList();
        if (entitiesFound.isEmpty()) {
            return null;
        }
        return entitiesFound.get(0);
    }

    public AdminAccountMaster findByAccountId(String id) {
        List<AdminAccountMaster> list = (List<AdminAccountMaster>) em.createNamedQuery("AdminAccountMaster.findById", AdminAccountMaster.class)
            .setParameter("id", id).getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
