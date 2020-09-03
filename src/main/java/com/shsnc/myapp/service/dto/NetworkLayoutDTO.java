package com.shsnc.myapp.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import com.shsnc.myapp.domain.enumeration.StartStatus;

/**
 * A DTO for the {@link com.shsnc.myapp.domain.NetworkLayout} entity.
 */
public class NetworkLayoutDTO implements Serializable {
    
    private Long id;

    private Long menuId;

    private String ipAdderssType;

    private String ipType;

    private Integer netmask;

    private String networkName;

    private String networkDesc;

    private String networkRange;

    private BigDecimal total;

    private String gatewayAddress;

    private String vlanId;

    private String dns;

    private StartStatus status;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getIpAdderssType() {
        return ipAdderssType;
    }

    public void setIpAdderssType(String ipAdderssType) {
        this.ipAdderssType = ipAdderssType;
    }

    public String getIpType() {
        return ipType;
    }

    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    public Integer getNetmask() {
        return netmask;
    }

    public void setNetmask(Integer netmask) {
        this.netmask = netmask;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getNetworkDesc() {
        return networkDesc;
    }

    public void setNetworkDesc(String networkDesc) {
        this.networkDesc = networkDesc;
    }

    public String getNetworkRange() {
        return networkRange;
    }

    public void setNetworkRange(String networkRange) {
        this.networkRange = networkRange;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getGatewayAddress() {
        return gatewayAddress;
    }

    public void setGatewayAddress(String gatewayAddress) {
        this.gatewayAddress = gatewayAddress;
    }

    public String getVlanId() {
        return vlanId;
    }

    public void setVlanId(String vlanId) {
        this.vlanId = vlanId;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public StartStatus getStatus() {
        return status;
    }

    public void setStatus(StartStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NetworkLayoutDTO)) {
            return false;
        }

        return id != null && id.equals(((NetworkLayoutDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NetworkLayoutDTO{" +
            "id=" + getId() +
            ", menuId=" + getMenuId() +
            ", ipAdderssType='" + getIpAdderssType() + "'" +
            ", ipType='" + getIpType() + "'" +
            ", netmask=" + getNetmask() +
            ", networkName='" + getNetworkName() + "'" +
            ", networkDesc='" + getNetworkDesc() + "'" +
            ", networkRange='" + getNetworkRange() + "'" +
            ", total=" + getTotal() +
            ", gatewayAddress='" + getGatewayAddress() + "'" +
            ", vlanId='" + getVlanId() + "'" +
            ", dns='" + getDns() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
