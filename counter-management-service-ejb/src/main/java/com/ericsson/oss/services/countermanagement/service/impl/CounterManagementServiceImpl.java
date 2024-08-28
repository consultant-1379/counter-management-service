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
package com.ericsson.oss.services.countermanagement.service.impl;

import com.ericsson.oss.services.countermanagement.api.CounterManagementService;
import com.ericsson.oss.services.countermanagement.api.dto.FlexCounterDTO;
import com.ericsson.oss.services.countermanagement.db.dao.FlexCounterDAO;

import com.ericsson.oss.services.countermanagement.db.entities.FlexCounter;
import com.ericsson.oss.services.countermanagement.util.MapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.*;
import java.util.List;
import java.util.Map;

@Stateless
@Local(CounterManagementService.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CounterManagementServiceImpl implements CounterManagementService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CounterManagementServiceImpl.class);

    @EJB
    private FlexCounterDAO flexCounterDAO;

    @Override
    public List<FlexCounterDTO> getFlexCounters() {
        LOGGER.debug("will get all flex counters from db");
        return MapperUtil.convertToDtoList(getFlexCounterDAO().getAllFlexCounters());
    }

    @Override
    public FlexCounterDTO getFlexCounterByName(final String counterName) {
        LOGGER.debug("will get flex counter by name from db");
        return MapperUtil.convertToDto(getFlexCounterDAO().getFlexCounterByName(counterName));
    }

    @Override
    public List<FlexCounterDTO> createFlexCounters(final List<FlexCounterDTO> flexCounterDTOs){
        LOGGER.debug("will create flex counters in db");
        List <FlexCounter> flexCounters = MapperUtil.convertToEntityList(flexCounterDTOs);
        return MapperUtil.convertToDtoList(getFlexCounterDAO().create(flexCounters));
    }

    @Override
    public Map<String, String> deleteFlexCounters(final List<FlexCounterDTO> flexCounterDTOs){
        LOGGER.debug("will delete flex counters from db");
        return getFlexCounterDAO().delete(MapperUtil.convertToEntityList(flexCounterDTOs));
    }

    @Override
    public FlexCounterDTO updateFlexCounter(final FlexCounterDTO flexCounterDTO) {
        LOGGER.debug("will update flex counter in db");
        FlexCounter flexCounter = MapperUtil.convertToEntity(flexCounterDTO);
        return MapperUtil.convertToDto(getFlexCounterDAO().update(flexCounter));
    }

    public FlexCounterDAO getFlexCounterDAO() {
        return flexCounterDAO;
    }
}
