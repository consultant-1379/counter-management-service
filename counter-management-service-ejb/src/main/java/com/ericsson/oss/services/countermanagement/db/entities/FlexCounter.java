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
package com.ericsson.oss.services.countermanagement.db.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "flex_counter")
@NamedQueries({
        @NamedQuery(name = FlexCounter.FIND_ALL, query = "SELECT f FROM FlexCounter f"),
        @NamedQuery(name = FlexCounter.FIND_BY_NAME, query = "SELECT f FROM FlexCounter f WHERE f.flexCounterName = :pflexCounterName")
})
public class FlexCounter implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Constants for Named Queries. */
    public static final String FIND_ALL = "FlexCounter.findAll";

    public static final String FIND_BY_NAME = "FlexCounter.findByName";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flex_counter_id_seq")
    @SequenceGenerator(name = "flex_counter_id_seq", sequenceName = "flex_counter_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "flex_counter_name", unique = true)
    private String flexCounterName;

    @Column(name = "base_counter_name")
    private String basecounterName;

    @Column(name = "description")
    private String description;

    @Column(name = "flex_filter_name")
    private String flexFilterName;

    @Column(name = "node_type")
    private String nodeType;

    @Column(name = "network_function")
    private String networkFunction;

    @Column(name = "source_object")
    private String sourceObject;

    @Column(name = "counter_status")
    private Integer status;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Timestamp createdDate;

   /** unidirectional one-to-many association to FlexCounterDetail. */
    @OneToMany(fetch = EAGER, cascade = ALL )
    @JoinColumn(name = "flex_counter_id", referencedColumnName = "id", nullable = false)
    @Size(min = 1)
    @NotNull
    private Set<FlexCounterDetail> flexCounterDetails;

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

    public Set<FlexCounterDetail> getFlexCounterDetails() {
        return flexCounterDetails;
    }

    public void setFlexCounterDetails(Set<FlexCounterDetail> flexCounterDetails) {
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
        final FlexCounter that = (FlexCounter) o;
        return id.equals(that.id) && flexCounterName.equals(that.flexCounterName);
    }

    @Override
    public String toString() {
        return "FlexCounter [id=" + id + ", flexCounterName=" + flexCounterName +
                ", basecounterName=" + basecounterName +
                ", description=" + description +
                ", flexFilterName=" + flexFilterName +
                ", nodeType=" + nodeType+
                ", networkFunction=" + networkFunction +
                ", sourceObject=" + sourceObject +
                ", status=" + status +
                ", flexCounterDetails=" + flexCounterDetails.toString() +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                "]";
    }

}
