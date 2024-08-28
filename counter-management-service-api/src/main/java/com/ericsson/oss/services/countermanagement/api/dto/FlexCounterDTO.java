package com.ericsson.oss.services.countermanagement.api.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * This DTO class will be used to persist objects to the Database, (DTO) Data Transfer Object
 */
public class FlexCounterDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String flexCounterName;

    private String basecounterName;

    private String description;

    private String flexFilterName;

    private String nodeType;

    private String networkFunction;

    private String sourceObject;

    private Integer status;

    private String createdBy;

    private Timestamp createdDate;

    private Set<FlexCounterDetailDTO> flexCounterDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlexCounterName() {
        return flexCounterName;
    }

    public void setFlexCounterName(String flexCounterName) {
        this.flexCounterName = flexCounterName;
    }

    public String getBasecounterName() {
        return basecounterName;
    }

    public void setBasecounterName(String basecounterName) {
        this.basecounterName = basecounterName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlexFilterName() {
        return flexFilterName;
    }

    public void setFlexFilterName(String flexFilterName) {
        this.flexFilterName = flexFilterName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getNetworkFunction() {
        return networkFunction;
    }

    public void setNetworkFunction(String networkFunction) {
        this.networkFunction = networkFunction;
    }

    public String getSourceObject() {
        return sourceObject;
    }

    public void setSourceObject(String sourceObject) {
        this.sourceObject = sourceObject;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Set<FlexCounterDetailDTO> getFlexCounterDetails() {
        return flexCounterDetails;
    }

    public void setFlexCounterDetails(Set<FlexCounterDetailDTO> flexCounterDetails) {
        this.flexCounterDetails = flexCounterDetails;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((flexCounterName == null) ? 0 : flexCounterName.hashCode());
        result = prime * result + ((basecounterName == null) ? 0 : basecounterName.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((flexFilterName == null) ? 0 : flexFilterName.hashCode());
        result = prime * result + ((nodeType == null) ? 0 : nodeType.hashCode());
        result = prime * result + ((networkFunction == null) ? 0 : networkFunction.hashCode());
        result = prime * result + ((sourceObject == null) ? 0 : sourceObject.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
        result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
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
        final FlexCounterDTO that = (FlexCounterDTO) o;
        return id.equals(that.id) && flexCounterName.equals(that.flexCounterName);
    }

    @Override
    public String toString() {
        return "FlexCounter [id=" + id + ", flexCounterName=" + flexCounterName +
                ", basecounterName=" + basecounterName +
                ", description=" + description +
                ", flexFilterName=" + flexFilterName +
                ", nodeType=" + nodeType +
                ", networkFunction=" + networkFunction +
                ", sourceObject=" + sourceObject +
                ", status=" + status +
                ", flexCounterDetails=" + flexCounterDetails.toString() +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                "]";
    }

}
