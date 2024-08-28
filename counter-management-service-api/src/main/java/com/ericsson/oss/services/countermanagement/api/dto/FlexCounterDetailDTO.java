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
package com.ericsson.oss.services.countermanagement.api.dto;

import java.io.Serializable;


public class FlexCounterDetailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String event;

    private String eventParam;

    private String filterName;

    private String filterValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventParam() {
        return eventParam;
    }

    public void setEventParam(String eventParam) {
        this.eventParam = eventParam;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((event == null) ? 0 : event.hashCode());
        result = prime * result + ((eventParam == null) ? 0 : eventParam.hashCode());
        result = prime * result + ((filterName == null) ? 0 : filterName.hashCode());
        result = prime * result + ((filterValue == null) ? 0 : filterValue.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final FlexCounterDetailDTO that = (FlexCounterDetailDTO) o;
        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return "FlexCounterDetailDTO [id=" + id +
                ", event=" + event +
                ", eventParam=" + eventParam +
                ", filterName=" + filterName +
                ", value=" + filterValue+
                "]";
    }
}