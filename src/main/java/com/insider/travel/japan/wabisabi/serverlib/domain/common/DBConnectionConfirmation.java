package com.insider.travel.japan.wabisabi.serverlib.domain.common;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * DB Connection Confirmation Class
 */
@Dependent
public class DBConnectionConfirmation {

    final private static String SQLSTRING_DBCONNECT_COMFIRM = "select 2";

    @Inject
    protected EntityManager em;

    public boolean connectionOK() {
        try {
            Query query = em.createNativeQuery(SQLSTRING_DBCONNECT_COMFIRM);
            Object result = query.getSingleResult();
        } catch (Exception e) {
            // When fail to perform SQL, SQL cannot be connected
            return false;
        }
        return true;
    }

}
