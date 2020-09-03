package com.shsnc.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.shsnc.myapp.domain.enumeration.StartStatus;

/**
 * A NetworkLayout.
 */
@Entity
@Table(name = "network_layout")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class NetworkLayout implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name = "auto_id", unique = true)
    private Long autoId;

    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "ip_adderss_type")
    private String ipAdderssType;

    @Column(name = "ip_type")
    private String ipType;

    @Column(name = "netmask")
    private Integer netmask;

    @Column(name = "network_name")
    private String networkName;

    @Column(name = "network_desc")
    private String networkDesc;

    @Column(name = "network_range")
    private String networkRange;

    @Column(name = "total", precision = 21, scale = 2)
    private BigDecimal total;

    @Column(name = "gateway_address")
    private String gatewayAddress;

    @Column(name = "vlan_id")
    private String vlanId;

    @Column(name = "dns")
    private String dns;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StartStatus status;

    @OneToMany(mappedBy = "networkLayout")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<NetworkAssign> networkAssigns = new HashSet<>();

    @OneToMany(mappedBy = "networkLayout")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<NetworkAssignModify> networkAssignModifies = new HashSet<>();

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

    public NetworkLayout autoId(Long autoId) {
        this.autoId = autoId;
        return this;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public NetworkLayout menuId(Long menuId) {
        this.menuId = menuId;
        return this;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getIpAdderssType() {
        return ipAdderssType;
    }

    public NetworkLayout ipAdderssType(String ipAdderssType) {
        this.ipAdderssType = ipAdderssType;
        return this;
    }

    public void setIpAdderssType(String ipAdderssType) {
        this.ipAdderssType = ipAdderssType;
    }

    public String getIpType() {
        return ipType;
    }

    public NetworkLayout ipType(String ipType) {
        this.ipType = ipType;
        return this;
    }

    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    public Integer getNetmask() {
        return netmask;
    }

    public NetworkLayout netmask(Integer netmask) {
        this.netmask = netmask;
        return this;
    }

    public void setNetmask(Integer netmask) {
        this.netmask = netmask;
    }

    public String getNetworkName() {
        return networkName;
    }

    public NetworkLayout networkName(String networkName) {
        this.networkName = networkName;
        return this;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getNetworkDesc() {
        return networkDesc;
    }

    public NetworkLayout networkDesc(String networkDesc) {
        this.networkDesc = networkDesc;
        return this;
    }

    public void setNetworkDesc(String networkDesc) {
        this.networkDesc = networkDesc;
    }

    public String getNetworkRange() {
        return networkRange;
    }

    public NetworkLayout networkRange(String networkRange) {
        this.networkRange = networkRange;
        return this;
    }

    public void setNetworkRange(String networkRange) {
        this.networkRange = networkRange;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public NetworkLayout total(BigDecimal total) {
        this.total = total;
        return this;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getGatewayAddress() {
        return gatewayAddress;
    }

    public NetworkLayout gatewayAddress(String gatewayAddress) {
        this.gatewayAddress = gatewayAddress;
        return this;
    }

    public void setGatewayAddress(String gatewayAddress) {
        this.gatewayAddress = gatewayAddress;
    }

    public String getVlanId() {
        return vlanId;
    }

    public NetworkLayout vlanId(String vlanId) {
        this.vlanId = vlanId;
        return this;
    }

    public void setVlanId(String vlanId) {
        this.vlanId = vlanId;
    }

    public String getDns() {
        return dns;
    }

    public NetworkLayout dns(String dns) {
        this.dns = dns;
        return this;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public StartStatus getStatus() {
        return status;
    }

    public NetworkLayout status(StartStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(StartStatus status) {
        this.status = status;
    }

    public Set<NetworkAssign> getNetworkAssigns() {
        return networkAssigns;
    }

    public NetworkLayout networkAssigns(Set<NetworkAssign> networkAssigns) {
        this.networkAssigns = networkAssigns;
        return this;
    }

    public NetworkLayout addNetworkAssign(NetworkAssign networkAssign) {
        this.networkAssigns.add(networkAssign);
        networkAssign.setNetworkLayout(this);
        return this;
    }

    public NetworkLayout removeNetworkAssign(NetworkAssign networkAssign) {
        this.networkAssigns.remove(networkAssign);
        networkAssign.setNetworkLayout(null);
        return this;
    }

    public void setNetworkAssigns(Set<NetworkAssign> networkAssigns) {
        this.networkAssigns = networkAssigns;
    }

    public Set<NetworkAssignModify> getNetworkAssignModifies() {
        return networkAssignModifies;
    }

    public NetworkLayout networkAssignModifies(Set<NetworkAssignModify> networkAssignModifies) {
        this.networkAssignModifies = networkAssignModifies;
        return this;
    }

    public NetworkLayout addNetworkAssignModify(NetworkAssignModify networkAssignModify) {
        this.networkAssignModifies.add(networkAssignModify);
        networkAssignModify.setNetworkLayout(this);
        return this;
    }

    public NetworkLayout removeNetworkAssignModify(NetworkAssignModify networkAssignModify) {
        this.networkAssignModifies.remove(networkAssignModify);
        networkAssignModify.setNetworkLayout(null);
        return this;
    }

    public void setNetworkAssignModifies(Set<NetworkAssignModify> networkAssignModifies) {
        this.networkAssignModifies = networkAssignModifies;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NetworkLayout)) {
            return false;
        }
        return id != null && id.equals(((NetworkLayout) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NetworkLayout{" +
            "id=" + getId() +
            ", autoId=" + getAutoId() +
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
