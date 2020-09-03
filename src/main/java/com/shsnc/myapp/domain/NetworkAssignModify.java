package com.shsnc.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;

import com.shsnc.myapp.domain.enumeration.ModifySource;

import com.shsnc.myapp.domain.enumeration.ModifyType;

/**
 * A NetworkAssignModify.
 */
@Entity
@Table(name = "network_assign_modify")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class NetworkAssignModify implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name = "auto_id", unique = true)
    private Long autoId;

    @Column(name = "title")
    private String title;

    @Column(name = "update_time")
    private Integer updateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "modify_source")
    private ModifySource modifySource;

    @Column(name = "external_id")
    private Integer externalId;

    @Enumerated(EnumType.STRING)
    @Column(name = "modify_type")
    private ModifyType modifyType;

    @Column(name = "modified_count", precision = 21, scale = 2)
    private BigDecimal modifiedCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "modify_status")
    private ModifySource modifyStatus;

    @Column(name = "order_detail_id")
    private Integer orderDetailId;

    @Column(name = "manager_id")
    private Integer managerId;

    @Column(name = "manager_value")
    private String managerValue;

    @Column(name = "system_id")
    private Integer systemId;

    @Column(name = "system_value")
    private String systemValue;

    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_value")
    private String departmentValue;

    @ManyToOne
    @JsonIgnoreProperties(value = "networkAssignModifies", allowSetters = true)
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

    public NetworkAssignModify autoId(Long autoId) {
        this.autoId = autoId;
        return this;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    public String getTitle() {
        return title;
    }

    public NetworkAssignModify title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public NetworkAssignModify updateTime(Integer updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public ModifySource getModifySource() {
        return modifySource;
    }

    public NetworkAssignModify modifySource(ModifySource modifySource) {
        this.modifySource = modifySource;
        return this;
    }

    public void setModifySource(ModifySource modifySource) {
        this.modifySource = modifySource;
    }

    public Integer getExternalId() {
        return externalId;
    }

    public NetworkAssignModify externalId(Integer externalId) {
        this.externalId = externalId;
        return this;
    }

    public void setExternalId(Integer externalId) {
        this.externalId = externalId;
    }

    public ModifyType getModifyType() {
        return modifyType;
    }

    public NetworkAssignModify modifyType(ModifyType modifyType) {
        this.modifyType = modifyType;
        return this;
    }

    public void setModifyType(ModifyType modifyType) {
        this.modifyType = modifyType;
    }

    public BigDecimal getModifiedCount() {
        return modifiedCount;
    }

    public NetworkAssignModify modifiedCount(BigDecimal modifiedCount) {
        this.modifiedCount = modifiedCount;
        return this;
    }

    public void setModifiedCount(BigDecimal modifiedCount) {
        this.modifiedCount = modifiedCount;
    }

    public ModifySource getModifyStatus() {
        return modifyStatus;
    }

    public NetworkAssignModify modifyStatus(ModifySource modifyStatus) {
        this.modifyStatus = modifyStatus;
        return this;
    }

    public void setModifyStatus(ModifySource modifyStatus) {
        this.modifyStatus = modifyStatus;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public NetworkAssignModify orderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
        return this;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public NetworkAssignModify managerId(Integer managerId) {
        this.managerId = managerId;
        return this;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerValue() {
        return managerValue;
    }

    public NetworkAssignModify managerValue(String managerValue) {
        this.managerValue = managerValue;
        return this;
    }

    public void setManagerValue(String managerValue) {
        this.managerValue = managerValue;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public NetworkAssignModify systemId(Integer systemId) {
        this.systemId = systemId;
        return this;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getSystemValue() {
        return systemValue;
    }

    public NetworkAssignModify systemValue(String systemValue) {
        this.systemValue = systemValue;
        return this;
    }

    public void setSystemValue(String systemValue) {
        this.systemValue = systemValue;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public NetworkAssignModify departmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentValue() {
        return departmentValue;
    }

    public NetworkAssignModify departmentValue(String departmentValue) {
        this.departmentValue = departmentValue;
        return this;
    }

    public void setDepartmentValue(String departmentValue) {
        this.departmentValue = departmentValue;
    }

    public NetworkLayout getNetworkLayout() {
        return networkLayout;
    }

    public NetworkAssignModify networkLayout(NetworkLayout networkLayout) {
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
        if (!(o instanceof NetworkAssignModify)) {
            return false;
        }
        return id != null && id.equals(((NetworkAssignModify) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NetworkAssignModify{" +
            "id=" + getId() +
            ", autoId=" + getAutoId() +
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
            "}";
    }
}
