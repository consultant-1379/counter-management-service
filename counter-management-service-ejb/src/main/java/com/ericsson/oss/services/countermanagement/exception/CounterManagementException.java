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
package com.ericsson.oss.services.countermanagement.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class CounterManagementException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CounterManagementException(final String message) {
        super(message);
    }

}
