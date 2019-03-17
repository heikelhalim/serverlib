package com.insider.travel.japan.wabisabi.serverlib.domain.dao;

import com.insider.travel.japan.wabisabi.serverlib.domain.model.AdminLockedOut;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;

/**
 *
 *  
 */
@Dependent
public class AdminLockedOutDao extends AbstractCommonDao<AdminLockedOut> {
    
    public AdminLockedOut findOne(String id) {
        return getEntityManager().find(AdminLockedOut.class, id);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
