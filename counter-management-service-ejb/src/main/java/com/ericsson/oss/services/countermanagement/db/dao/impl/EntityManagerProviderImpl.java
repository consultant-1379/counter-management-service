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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This providing access to entity manager.
 *
 */
public class EntityManagerProviderImpl implements EntityManagerProvider {

    @PersistenceContext(name = "ebsm-flex-counter")
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
