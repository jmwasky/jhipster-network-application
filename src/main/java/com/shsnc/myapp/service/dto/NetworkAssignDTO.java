package com.shsnc.myapp.service.dto;

import java.io.Serializable;
import com.shsnc.myapp.domain.enumeration.AllocateStatus;

/**
 * A DTO for the {@link com.shsnc.myapp.domain.NetworkAssign} entity.
 */
public class NetworkAssignDTO implements Serializable {
    
    private Long id;

    private String ipAddress;

    private Integer departmentId;

    private String departmentValue;

    private Integer systemId;

    private String systemValue;

    private Integer managerId;

    private String managerValue;

    private String resourceIds;

    private AllocateStatus allocateStatus;

    private String ipDescribe;

    private Integer updateTime;


    private Long networkLayoutId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentValue() {
        return departmentValue;
    }

    public void setDepartmentValue(String departmentValue) {
        this.departmentValue = departmentValue;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getSystemValue() {
        return systemValue;
    }

    public void setSystemValue(String systemValue) {
        this.systemValue = systemValue;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerValue() {
        return managerValue;
    }

    public void setManagerValue(String managerValue) {
        this.managerValue = managerValue;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public AllocateStatus getAllocateStatus() {
        return allocateStatus;
    }

    public void setAllocateStatus(AllocateStatus allocateStatus) {
        this.allocateStatus = allocateStatus;
    }

    public String getIpDescribe() {
        return ipDescribe;
    }

    public void setIpDescribe(String ipDescribe) {
        this.ipDescribe = ipDescribe;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Long getNetworkLayoutId() {
        return networkLayoutId;
    }

    public void setNetworkLayoutId(Long networkLayoutId) {
        this.networkLayoutId = networkLayoutId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NetworkAssignDTO)) {
            return false;
        }

        return id != null && id.equals(((NetworkAssignDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NetworkAssignDTO{" +
            "id=" + getId() +
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
            ", networkLayoutId=" + getNetworkLayoutId() +
            "}";
    }
}
