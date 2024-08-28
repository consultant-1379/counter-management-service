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
package com.ericsson.oss.services.countermanagement.api;

/**
 * Provides the methods to manipulate the DTO classes, (DTO) Data Transfer Object
 */

import com.ericsson.oss.services.countermanagement.api.dto.FlexCounterDTO;

import java.util.List;
import java.util.Map;

/**
 * Provides the methods to manipulate the DTO classes, (DTO) Data Transfer Object
 */
public interface CounterManagementService {

    List<FlexCounterDTO> getFlexCounters() ;

    FlexCounterDTO getFlexCounterByName(final String counterName);

    List<FlexCounterDTO> createFlexCounters(final List<FlexCounterDTO> flexCounters);

    FlexCounterDTO updateFlexCounter(final FlexCounterDTO flexCounter);

    Map<String, String> deleteFlexCounters(final List<FlexCounterDTO> flexCounters);

}