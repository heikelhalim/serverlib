package com.insider.travel.japan.wabisabi.serverlib.domain.dao;

import com.insider.travel.japan.wabisabi.serverlib.domain.model.CommonModel;
import com.insider.travel.japan.wabisabi.serverlib.server.Metadata;
import com.insider.travel.japan.wabisabi.serverlib.utils.common.DateUtil;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * Service common class
 * @param <T>
 */
public abstract class AbstractCommonDao<T extends CommonModel> {

    @Inject
    protected EntityManager em;

    @Inject
    protected Metadata metadata;

    private Class<T> entityClass;

    protected void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    @Transactional
    public T create(T entity) {
        // Set data on common columns
        Date date = DateUtil.getCurrentDate();
        entity.setCreatedBy(getOperator());
        entity.setCreatedAt(date);
        entity.setUpdatedBy(getOperator());
        entity.setUpdatedAt(date);
        getEntityManager().persist(entity);

        return entity;
    }

    @Transactional
    public T edit(T entity) {
        // Set data on common columns
        Date date = DateUtil.getCurrentDate();
        entity.setUpdatedBy(getOperator());
        entity.setUpdatedAt(date);
        getEntityManager().merge(entity);

        return entity;
    }

    @Transactional
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public void flush() {
        getEntityManager().flush();
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public T findOne(T entity) {
        return getEntityManager().find(entityClass, entity);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(entityClass));

        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(entityClass));
        javax.persistence.Query query = getEntityManager().createQuery(criteriaQuery);
        query.setMaxResults(range[1] - range[0] + 1);
        query.setFirstResult(range[0]);

        return query.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(getEntityManager().getCriteriaBuilder().count(root));
        javax.persistence.Query query = getEntityManager().createQuery(criteriaQuery);

        return ((Long) query.getSingleResult()).intValue();
    }

    // Type of server that change took place
    private String getOperator() {
        return metadata.getAvailabilityZone() + "_" + metadata.getPrivateDns();
    }

}
