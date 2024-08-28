/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2014
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson.oss.services.countermanagement.ejb.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.ericsson.oss.services.countermanagement.impl.DateResolverBean;

@Stateless
public class CounterManagementServiceBean implements CounterManagementServiceRemote, CounterManagementServiceLocal {

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    @Inject
    private Logger logger;

    @Inject
    private DateResolverBean dateResolver;

}
