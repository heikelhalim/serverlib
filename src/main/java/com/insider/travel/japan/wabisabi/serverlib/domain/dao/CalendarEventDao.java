package com.insider.travel.japan.wabisabi.serverlib.domain.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;

import com.insider.travel.japan.wabisabi.serverlib.domain.model.AdminAccountMaster;
import com.insider.travel.japan.wabisabi.serverlib.domain.model.CalendarEvent;

@Dependent
public class CalendarEventDao extends AbstractCommonDao<CalendarEvent> {
	
	//Get Calendar Event based on Id
    public CalendarEvent findEventById(String id) {
        List<CalendarEvent> entitiesFound = (List<CalendarEvent>) em.createNamedQuery("CalendarEvent.findEventById", CalendarEvent.class)
            .setParameter("id", id).getResultList();
        if (entitiesFound.isEmpty()) {
            return null;
        }
        return entitiesFound.get(0);
    }

   //Get list of Calendar Events based on AccountId 
    public List<CalendarEvent> findEventsByAccountId(String accountId) {
        return (List<CalendarEvent>) em.createNamedQuery("CalendarEvent.findEventsByAccountId", CalendarEvent.class)
        		.setParameter("accountId", accountId).getResultList();
    }
    
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
