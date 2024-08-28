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
package com.ericsson.oss.services.countermanagement.util;

import com.ericsson.oss.services.countermanagement.api.dto.FlexCounterDTO;
import com.ericsson.oss.services.countermanagement.db.entities.FlexCounter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;

import java.lang.reflect.Type;
import java.util.*;

/**
 *  This Util will converts DTO to Entity and vice versa
 */

public class MapperUtil {

    private static ModelMapper modelMapper ;

    /**
     * Model mapper property setting are specified in the following block.
     * Default property matching strategy is set to Strict see {@link MatchingStrategies}
     */
    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static FlexCounter convertToEntity(FlexCounterDTO flexCounterDto){
        FlexCounter flexCounter = modelMapper.map(flexCounterDto, FlexCounter.class);
        return flexCounter;
    }

    public static FlexCounterDTO convertToDto(FlexCounter flexCounter){
        FlexCounterDTO flexCounterDTO = modelMapper.map(flexCounter, FlexCounterDTO.class);
        return flexCounterDTO;
    }

    public static List<FlexCounterDTO> convertToDtoList(List<FlexCounter> flexCounters){
        Type listType = new TypeToken<List<FlexCounterDTO>>() {}.getType();
        List<FlexCounterDTO> flexCounterDTOs = modelMapper.map(flexCounters, listType);
        return flexCounterDTOs;
    }

    public  static List<FlexCounter> convertToEntityList(List<FlexCounterDTO> flexCounterDTOs){
        Type listType = new TypeToken<List<FlexCounter>>() {}.getType();
        List<FlexCounter> flexCounters = modelMapper.map(flexCounterDTOs, listType);
        return flexCounters;
    }

}
