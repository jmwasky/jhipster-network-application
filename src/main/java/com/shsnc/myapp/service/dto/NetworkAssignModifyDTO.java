package com.shsnc.myapp.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import com.shsnc.myapp.domain.enumeration.ModifySource;
import com.shsnc.myapp.domain.enumeration.ModifyType;

/**
 * A DTO for the {@link com.shsnc.myapp.domain.NetworkAssignModify} entity.
 */
public class NetworkAssignModifyDTO implements Serializable {
    
    private Long id;

    private String title;

    private Integer updateTime;

    private ModifySource modifySource;

    private Integer externalId;

    private ModifyType modifyType;

    private BigDecimal modifiedCount;

    private ModifySource modifyStatus;

    private Integer orderDetailId;

    private Integer managerId;

    private String managerValue;

    private Integer systemId;

    private String systemValue;

    private Integer departmentId;

    private String departmentValue;


    private Long networkLayoutId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public ModifySource getModifySource() {
        return modifySource;
    }

    public void setModifySource(ModifySource modifySource) {
        this.modifySource = modifySource;
    }

    public Integer getExternalId() {
        return externalId;
    }

    public void setExternalId(Integer externalId) {
        this.externalId = externalId;
    }

    public ModifyType getModifyType() {
        return modifyType;
    }

    public void setModifyType(ModifyType modifyType) {
        this.modifyType = modifyType;
    }

    public BigDecimal getModifiedCount() {
        return modifiedCount;
    }

    public void setModifiedCount(BigDecimal modifiedCount) {
        this.modifiedCount = modifiedCount;
    }

    public ModifySource getModifyStatus() {
        return modifyStatus;
    }

    public void setModifyStatus(ModifySource modifyStatus) {
        this.modifyStatus = modifyStatus;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
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
        if (!(o instanceof NetworkAssignModifyDTO)) {
            return false;
        }

        return id != null && id.equals(((NetworkAssignModifyDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NetworkAssignModifyDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", updateTime=" + getUpdateTime() +
            ", modifySource='" + getModifySource() + "'" +
            ", externalId=" + getExternalId() +
            ", modifyType='" + getModifyType() + "'" +
            ", modifiedCount=" + getModifiedCount() +
            ", modifyStatus='" + getModifyStatus() + "'" +
            ", orderDetailId=" + getOrderDetailId() +
            ", managerId=" + getManagerId() +
            ", managerValue='" + getManagerValue() + "'" +
            ", systemId=" + getSystemId() +
            ", systemValue='" + getSystemValue() + "'" +
            ", departmentId=" + getDepartmentId() +
            ", departmentValue='" + getDepartmentValue() + "'" +
            ", networkLayoutId=" + getNetworkLayoutId() +
            "}";
    }
}
