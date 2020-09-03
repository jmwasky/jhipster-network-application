package com.shsnc.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

import com.shsnc.myapp.domain.enumeration.AllocateStatus;

/**
 * A NetworkAssign.
 */
@Entity
@Table(name = "network_assign")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class NetworkAssign implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name = "auto_id", unique = true)
    private Long autoId;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_value")
    private String departmentValue;

    @Column(name = "system_id")
    private Integer systemId;

    @Column(name = "system_value")
    private String systemValue;

    @Column(name = "manager_id")
    private Integer managerId;

    @Column(name = "manager_value")
    private String managerValue;

    @Column(name = "resource_ids")
    private String resourceIds;

    @Enumerated(EnumType.STRING)
    @Column(name = "allocate_status")
    private AllocateStatus allocateStatus;

    @Column(name = "ip_describe")
    private String ipDescribe;

    @Column(name = "update_time")
    private Integer updateTime;

    @ManyToOne
    @JsonIgnoreProperties(value = "networkAssigns", allowSetters = true)
    private NetworkLayout networkLayout;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAutoId() {
        return autoId;
    }

    public NetworkAssign autoId(Long autoId) {
        this.autoId = autoId;
        return this;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public NetworkAssign ipAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public NetworkAssign departmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentValue() {
        return departmentValue;
    }

    public NetworkAssign departmentValue(String departmentValue) {
        this.departmentValue = departmentValue;
        return this;
    }

    public void setDepartmentValue(String departmentValue) {
        this.departmentValue = departmentValue;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public NetworkAssign systemId(Integer systemId) {
        this.systemId = systemId;
        return this;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getSystemValue() {
        return systemValue;
    }

    public NetworkAssign systemValue(String systemValue) {
        this.systemValue = systemValue;
        return this;
    }

    public void setSystemValue(String systemValue) {
        this.systemValue = systemValue;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public NetworkAssign managerId(Integer managerId) {
        this.managerId = managerId;
        return this;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerValue() {
        return managerValue;
    }

    public NetworkAssign managerValue(String managerValue) {
        this.managerValue = managerValue;
        return this;
    }

    public void setManagerValue(String managerValue) {
        this.managerValue = managerValue;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public NetworkAssign resourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
        return this;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public AllocateStatus getAllocateStatus() {
        return allocateStatus;
    }

    public NetworkAssign allocateStatus(AllocateStatus allocateStatus) {
        this.allocateStatus = allocateStatus;
        return this;
    }

    public void setAllocateStatus(AllocateStatus allocateStatus) {
        this.allocateStatus = allocateStatus;
    }

    public String getIpDescribe() {
        return ipDescribe;
    }

    public NetworkAssign ipDescribe(String ipDescribe) {
        this.ipDescribe = ipDescribe;
        return this;
    }

    public void setIpDescribe(String ipDescribe) {
        this.ipDescribe = ipDescribe;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public NetworkAssign updateTime(Integer updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public NetworkLayout getNetworkLayout() {
        return networkLayout;
    }

    public NetworkAssign networkLayout(NetworkLayout networkLayout) {
        this.networkLayout = networkLayout;
        return this;
    }

    public void setNetworkLayout(NetworkLayout networkLayout) {
        this.networkLayout = networkLayout;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NetworkAssign)) {
            return false;
        }
        return id != null && id.equals(((NetworkAssign) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NetworkAssign{" +
            "id=" + getId() +
            ", autoId=" + getAutoId() +
            ", ipAddress='" + getIpAddress() + "'" +
            ", departmentId=" + getDepartmentId() +
            ", departmentValue='" + getDepartmentValue() + "'" +
            ", systemId=" + getSystemId() +
            ", systemValue='" + getSystemValue() + "'" +
            ", managerId=" + getManagerId() +
            ", managerValue='" + getManagerValue() + "'" +
            ", resourceIds='" + getResourceIds() + "'" +
            ", allocateStatus='" + getAllocateStatus() + "'" +
            ", ipDescribe='" + getIpDescribe() + "'" +
            ", updateTime=" + getUpdateTime() +
            "}";
    }
}
