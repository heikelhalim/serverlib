package com.insider.travel.japan.wabisabi.serverlib.domain.common;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * 
 * 
 */
@Dependent
public class EntityManagerProducer {

    @PersistenceContext(unitName = "wabisabidbPU")
    @Produces
    private EntityManager em;

}
