/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2015
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson.oss.services.countermanagement.interceptor;

import com.ericsson.oss.itpf.sdk.recording.ErrorSeverity;
import com.ericsson.oss.itpf.sdk.recording.SystemRecorder;
import com.ericsson.oss.services.countermanagement.exception.EmergencyException;
import com.ericsson.oss.services.countermanagement.exception.CounterManagementException;


import javax.inject.Inject;
import javax.interceptor.*;
import javax.persistence.*;


@Interceptor
@Recordable
public class EntityManagerSystemRecorderInterceptor {

    private static final String POSTGRESQL = "POSTGRESQL";

    private static final String DATABASE_COMMUNICATION = "DATABASE_COMMUNICATION";

    @Inject
    private SystemRecorder systemRecorder;

    @AroundInvoke
    public Object recordErrorIfExceptionIsThrown(final InvocationContext invocationContext) throws CounterManagementException {
        try {
            return invocationContext.proceed();
        } catch (IllegalArgumentException | LockTimeoutException exception) {
            this.systemRecorder.recordError(DATABASE_COMMUNICATION, ErrorSeverity.WARNING, getSourceName(invocationContext), POSTGRESQL,
                    exception.toString());
            throw exception;
        } catch (PessimisticLockException | TransactionRequiredException | EntityExistsException exception) {
            this.systemRecorder.recordError(DATABASE_COMMUNICATION, ErrorSeverity.INFORMATIONAL, getSourceName(invocationContext), POSTGRESQL,
                    exception.toString());
            throw exception;
        } catch (final CounterManagementException exception) {
            throw exception;
        } catch (final Exception exception) {
            this.systemRecorder.recordError(DATABASE_COMMUNICATION, ErrorSeverity.EMERGENCY, getSourceName(invocationContext), POSTGRESQL,
                    exception.toString());
            throw new EmergencyException(exception);
        }
    }

    private String getSourceName(final InvocationContext context) {
        return context.getClass().getName() + "." + context.getMethod().getName();
    }
}
