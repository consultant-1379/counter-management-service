/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2019
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson.oss.services.countermanagement.db.dao.impl;

import com.ericsson.oss.services.countermanagement.db.dao.EntityManagerProvider;
import com.ericsson.oss.services.countermanagement.db.dao.FlexCounterDAO;
import com.ericsson.oss.services.countermanagement.db.entities.FlexCounter;

import com.ericsson.oss.services.countermanagement.interceptor.EntityManagerSystemRecorderInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.*;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.*;


/**
 * Class to handle all flex counter data access objects
 */
@Stateless
public class FlexCounterDAOImpl implements FlexCounterDAO {

    @Inject
    private Logger LOGGER;

    @Inject
    private EntityManagerProvider entityManagerProvider;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<FlexCounter> getAllFlexCounters() {
        final List<FlexCounter> flexCounters = getEntityManager().createNamedQuery(FlexCounter.FIND_ALL, FlexCounter.class).getResultList();
        if (flexCounters == null || flexCounters.isEmpty()) {
            LOGGER.debug("No FlexCounters found");
            return Collections.emptyList();
        }
        return flexCounters;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public FlexCounter getFlexCounterByName(String counterName) {
        final List<FlexCounter> flexCounters = getEntityManager().createNamedQuery(FlexCounter.FIND_BY_NAME, FlexCounter.class).setParameter("pflexCounterName",counterName).getResultList();
        if (flexCounters == null || flexCounters.isEmpty()) {
            LOGGER.debug("No FlexCounter found");
            return null;
        }
        return flexCounters.get(0);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Interceptors(EntityManagerSystemRecorderInterceptor.class)
    public List<FlexCounter> create(List<FlexCounter> flexCounters) {
    //TODO : first verify is this counters are already exists in DB
        if (flexCounters == null || flexCounters.isEmpty()) {
            LOGGER.debug("No Flex Counter found");
            return Collections.emptyList();
        }
        for (final FlexCounter flexCounter : flexCounters) {
            flexCounter.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            //TODO : Status should be read from Enum class. i.e 0 - Processing  , 1- Success
            flexCounter.setStatus(0);
            getEntityManager().persist(flexCounter);

        }
        return flexCounters;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Interceptors(EntityManagerSystemRecorderInterceptor.class)
    public FlexCounter update(FlexCounter flexCounter) {
        getEntityManager().merge(flexCounter);
        return flexCounter;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Interceptors(EntityManagerSystemRecorderInterceptor.class)
    public Map<String, String> delete(List<FlexCounter> flexCounters) {

        Map<String, String> deletedMap= new HashMap<>();
        for (final FlexCounter flexCounter : flexCounters) {
            getEntityManager().remove(getEntityManager().contains(flexCounter) ? flexCounter : getEntityManager().merge(flexCounter));
            deletedMap.put(flexCounter.getFlexCounterName(), "Success");
        }
        return deletedMap;
    }

    EntityManager getEntityManager() {
        return entityManagerProvider.getEntityManager();
    }
}
