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
package com.ericsson.oss.services.countermanagement.db.dao;

import com.ericsson.oss.services.countermanagement.db.entities.FlexCounter;

import java.util.List;
import java.util.Map;

public interface FlexCounterDAO {

    List<FlexCounter> getAllFlexCounters();

    FlexCounter getFlexCounterByName(String flexCounterName);

    List<FlexCounter> create(List<FlexCounter> flexCounters);

    FlexCounter update(FlexCounter flexCounter);

    Map<String, String> delete(List<FlexCounter> flexCounters);

}
