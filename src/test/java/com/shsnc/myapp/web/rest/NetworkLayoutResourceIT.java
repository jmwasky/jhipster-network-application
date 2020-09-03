package com.shsnc.myapp.web.rest;

import com.shsnc.myapp.JhipsterNetworkApplicationApp;
import com.shsnc.myapp.domain.NetworkLayout;
import com.shsnc.myapp.repository.NetworkLayoutRepository;
import com.shsnc.myapp.service.NetworkLayoutService;
import com.shsnc.myapp.service.dto.NetworkLayoutDTO;
import com.shsnc.myapp.service.mapper.NetworkLayoutMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.shsnc.myapp.domain.enumeration.StartStatus;
/**
 * Integration tests for the {@link NetworkLayoutResource} REST controller.
 */
@SpringBootTest(classes = JhipsterNetworkApplicationApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class NetworkLayoutResourceIT {

    private static final Long DEFAULT_AUTO_ID = 1L;
    private static final Long UPDATED_AUTO_ID = 2L;

    private static final Long DEFAULT_MENU_ID = 1L;
    private static final Long UPDATED_MENU_ID = 2L;

    private static final String DEFAULT_IP_ADDERSS_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_IP_ADDERSS_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_IP_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_IP_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_NETMASK = 1;
    private static final Integer UPDATED_NETMASK = 2;

    private static final String DEFAULT_NETWORK_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NETWORK_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_NETWORK_DESC = "AAAAAAAAAA";
    private static final String UPDATED_NETWORK_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_NETWORK_RANGE = "AAAAAAAAAA";
    private static final String UPDATED_NETWORK_RANGE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_TOTAL = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL = new BigDecimal(2);

    private static final String DEFAULT_GATEWAY_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_GATEWAY_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_VLAN_ID = "AAAAAAAAAA";
    private static final String UPDATED_VLAN_ID = "BBBBBBBBBB";

    private static final String DEFAULT_DNS = "AAAAAAAAAA";
    private static final String UPDATED_DNS = "BBBBBBBBBB";

    private static final StartStatus DEFAULT_STATUS = StartStatus.ENABLE;
    private static final StartStatus UPDATED_STATUS = StartStatus.DISABLE;

    @Autowired
    private NetworkLayoutRepository networkLayoutRepository;

    @Autowired
    private NetworkLayoutMapper networkLayoutMapper;

    @Autowired
    private NetworkLayoutService networkLayoutService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restNetworkLayoutMockMvc;

    private NetworkLayout networkLayout;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NetworkLayout createEntity(EntityManager em) {
        NetworkLayout networkLayout = new NetworkLayout()
            .autoId(DEFAULT_AUTO_ID)
            .menuId(DEFAULT_MENU_ID)
            .ipAdderssType(DEFAULT_IP_ADDERSS_TYPE)
            .ipType(DEFAULT_IP_TYPE)
            .netmask(DEFAULT_NETMASK)
            .networkName(DEFAULT_NETWORK_NAME)
            .networkDesc(DEFAULT_NETWORK_DESC)
            .networkRange(DEFAULT_NETWORK_RANGE)
            .total(DEFAULT_TOTAL)
            .gatewayAddress(DEFAULT_GATEWAY_ADDRESS)
            .vlanId(DEFAULT_VLAN_ID)
            .dns(DEFAULT_DNS)
            .status(DEFAULT_STATUS);
        return networkLayout;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NetworkLayout createUpdatedEntity(EntityManager em) {
        NetworkLayout networkLayout = new NetworkLayout()
            .autoId(UPDATED_AUTO_ID)
            .menuId(UPDATED_MENU_ID)
            .ipAdderssType(UPDATED_IP_ADDERSS_TYPE)
            .ipType(UPDATED_IP_TYPE)
            .netmask(UPDATED_NETMASK)
            .networkName(UPDATED_NETWORK_NAME)
            .networkDesc(UPDATED_NETWORK_DESC)
            .networkRange(UPDATED_NETWORK_RANGE)
            .total(UPDATED_TOTAL)
            .gatewayAddress(UPDATED_GATEWAY_ADDRESS)
            .vlanId(UPDATED_VLAN_ID)
            .dns(UPDATED_DNS)
            .status(UPDATED_STATUS);
        return networkLayout;
    }

    @BeforeEach
    public void initTest() {
        networkLayout = createEntity(em);
    }

    @Test
    @Transactional
    public void createNetworkLayout() throws Exception {
        int databaseSizeBeforeCreate = networkLayoutRepository.findAll().size();
        // Create the NetworkLayout
        NetworkLayoutDTO networkLayoutDTO = networkLayoutMapper.toDto(networkLayout);
        restNetworkLayoutMockMvc.perform(post("/api/network-layouts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(networkLayoutDTO)))
            .andExpect(status().isCreated());

        // Validate the NetworkLayout in the database
        List<NetworkLayout> networkLayoutList = networkLayoutRepository.findAll();
        assertThat(networkLayoutList).hasSize(databaseSizeBeforeCreate + 1);
        NetworkLayout testNetworkLayout = networkLayoutList.get(networkLayoutList.size() - 1);
        assertThat(testNetworkLayout.getAutoId()).isEqualTo(DEFAULT_AUTO_ID);
        assertThat(testNetworkLayout.getMenuId()).isEqualTo(DEFAULT_MENU_ID);
        assertThat(testNetworkLayout.getIpAdderssType()).isEqualTo(DEFAULT_IP_ADDERSS_TYPE);
        assertThat(testNetworkLayout.getIpType()).isEqualTo(DEFAULT_IP_TYPE);
        assertThat(testNetworkLayout.getNetmask()).isEqualTo(DEFAULT_NETMASK);
        assertThat(testNetworkLayout.getNetworkName()).isEqualTo(DEFAULT_NETWORK_NAME);
        assertThat(testNetworkLayout.getNetworkDesc()).isEqualTo(DEFAULT_NETWORK_DESC);
        assertThat(testNetworkLayout.getNetworkRange()).isEqualTo(DEFAULT_NETWORK_RANGE);
        assertThat(testNetworkLayout.getTotal()).isEqualTo(DEFAULT_TOTAL);
        assertThat(testNetworkLayout.getGatewayAddress()).isEqualTo(DEFAULT_GATEWAY_ADDRESS);
        assertThat(testNetworkLayout.getVlanId()).isEqualTo(DEFAULT_VLAN_ID);
        assertThat(testNetworkLayout.getDns()).isEqualTo(DEFAULT_DNS);
        assertThat(testNetworkLayout.getStatus()).isEqualTo(DEFAULT_STATUS);
    }

    @Test
    @Transactional
    public void createNetworkLayoutWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = networkLayoutRepository.findAll().size();

        // Create the NetworkLayout with an existing ID
        networkLayout.setId(1L);
        NetworkLayoutDTO networkLayoutDTO = networkLayoutMapper.toDto(networkLayout);

        // An entity with an existing ID cannot be created, so this API call must fail
        restNetworkLayoutMockMvc.perform(post("/api/network-layouts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(networkLayoutDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NetworkLayout in the database
        List<NetworkLayout> networkLayoutList = networkLayoutRepository.findAll();
        assertThat(networkLayoutList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllNetworkLayouts() throws Exception {
        // Initialize the database
        networkLayoutRepository.saveAndFlush(networkLayout);

        // Get all the networkLayoutList
        restNetworkLayoutMockMvc.perform(get("/api/network-layouts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(networkLayout.getId().intValue())))
            .andExpect(jsonPath("$.[*].autoId").value(hasItem(DEFAULT_AUTO_ID.intValue())))
            .andExpect(jsonPath("$.[*].menuId").value(hasItem(DEFAULT_MENU_ID.intValue())))
            .andExpect(jsonPath("$.[*].ipAdderssType").value(hasItem(DEFAULT_IP_ADDERSS_TYPE)))
            .andExpect(jsonPath("$.[*].ipType").value(hasItem(DEFAULT_IP_TYPE)))
            .andExpect(jsonPath("$.[*].netmask").value(hasItem(DEFAULT_NETMASK)))
            .andExpect(jsonPath("$.[*].networkName").value(hasItem(DEFAULT_NETWORK_NAME)))
            .andExpect(jsonPath("$.[*].networkDesc").value(hasItem(DEFAULT_NETWORK_DESC)))
            .andExpect(jsonPath("$.[*].networkRange").value(hasItem(DEFAULT_NETWORK_RANGE)))
            .andExpect(jsonPath("$.[*].total").value(hasItem(DEFAULT_TOTAL.intValue())))
            .andExpect(jsonPath("$.[*].gatewayAddress").value(hasItem(DEFAULT_GATEWAY_ADDRESS)))
            .andExpect(jsonPath("$.[*].vlanId").value(hasItem(DEFAULT_VLAN_ID)))
            .andExpect(jsonPath("$.[*].dns").value(hasItem(DEFAULT_DNS)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())));
    }
    
    @Test
    @Transactional
    public void getNetworkLayout() throws Exception {
        // Initialize the database
        networkLayoutRepository.saveAndFlush(networkLayout);

        // Get the networkLayout
        restNetworkLayoutMockMvc.perform(get("/api/network-layouts/{id}", networkLayout.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(networkLayout.getId().intValue()))
            .andExpect(jsonPath("$.autoId").value(DEFAULT_AUTO_ID.intValue()))
            .andExpect(jsonPath("$.menuId").value(DEFAULT_MENU_ID.intValue()))
            .andExpect(jsonPath("$.ipAdderssType").value(DEFAULT_IP_ADDERSS_TYPE))
            .andExpect(jsonPath("$.ipType").value(DEFAULT_IP_TYPE))
            .andExpect(jsonPath("$.netmask").value(DEFAULT_NETMASK))
            .andExpect(jsonPath("$.networkName").value(DEFAULT_NETWORK_NAME))
            .andExpect(jsonPath("$.networkDesc").value(DEFAULT_NETWORK_DESC))
            .andExpect(jsonPath("$.networkRange").value(DEFAULT_NETWORK_RANGE))
            .andExpect(jsonPath("$.total").value(DEFAULT_TOTAL.intValue()))
            .andExpect(jsonPath("$.gatewayAddress").value(DEFAULT_GATEWAY_ADDRESS))
            .andExpect(jsonPath("$.vlanId").value(DEFAULT_VLAN_ID))
            .andExpect(jsonPath("$.dns").value(DEFAULT_DNS))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingNetworkLayout() throws Exception {
        // Get the networkLayout
        restNetworkLayoutMockMvc.perform(get("/api/network-layouts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateNetworkLayout() throws Exception {
        // Initialize the database
        networkLayoutRepository.saveAndFlush(networkLayout);

        int databaseSizeBeforeUpdate = networkLayoutRepository.findAll().size();

        // Update the networkLayout
        NetworkLayout updatedNetworkLayout = networkLayoutRepository.findById(networkLayout.getId()).get();
        // Disconnect from session so that the updates on updatedNetworkLayout are not directly saved in db
        em.detach(updatedNetworkLayout);
        updatedNetworkLayout
            .autoId(UPDATED_AUTO_ID)
            .menuId(UPDATED_MENU_ID)
            .ipAdderssType(UPDATED_IP_ADDERSS_TYPE)
            .ipType(UPDATED_IP_TYPE)
            .netmask(UPDATED_NETMASK)
            .networkName(UPDATED_NETWORK_NAME)
            .networkDesc(UPDATED_NETWORK_DESC)
            .networkRange(UPDATED_NETWORK_RANGE)
            .total(UPDATED_TOTAL)
            .gatewayAddress(UPDATED_GATEWAY_ADDRESS)
            .vlanId(UPDATED_VLAN_ID)
            .dns(UPDATED_DNS)
            .status(UPDATED_STATUS);
        NetworkLayoutDTO networkLayoutDTO = networkLayoutMapper.toDto(updatedNetworkLayout);

        restNetworkLayoutMockMvc.perform(put("/api/network-layouts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(networkLayoutDTO)))
            .andExpect(status().isOk());

        // Validate the NetworkLayout in the database
        List<NetworkLayout> networkLayoutList = networkLayoutRepository.findAll();
        assertThat(networkLayoutList).hasSize(databaseSizeBeforeUpdate);
        NetworkLayout testNetworkLayout = networkLayoutList.get(networkLayoutList.size() - 1);
        assertThat(testNetworkLayout.getAutoId()).isEqualTo(UPDATED_AUTO_ID);
        assertThat(testNetworkLayout.getMenuId()).isEqualTo(UPDATED_MENU_ID);
        assertThat(testNetworkLayout.getIpAdderssType()).isEqualTo(UPDATED_IP_ADDERSS_TYPE);
        assertThat(testNetworkLayout.getIpType()).isEqualTo(UPDATED_IP_TYPE);
        assertThat(testNetworkLayout.getNetmask()).isEqualTo(UPDATED_NETMASK);
        assertThat(testNetworkLayout.getNetworkName()).isEqualTo(UPDATED_NETWORK_NAME);
        assertThat(testNetworkLayout.getNetworkDesc()).isEqualTo(UPDATED_NETWORK_DESC);
        assertThat(testNetworkLayout.getNetworkRange()).isEqualTo(UPDATED_NETWORK_RANGE);
        assertThat(testNetworkLayout.getTotal()).isEqualTo(UPDATED_TOTAL);
        assertThat(testNetworkLayout.getGatewayAddress()).isEqualTo(UPDATED_GATEWAY_ADDRESS);
        assertThat(testNetworkLayout.getVlanId()).isEqualTo(UPDATED_VLAN_ID);
        assertThat(testNetworkLayout.getDns()).isEqualTo(UPDATED_DNS);
        assertThat(testNetworkLayout.getStatus()).isEqualTo(UPDATED_STATUS);
    }

    @Test
    @Transactional
    public void updateNonExistingNetworkLayout() throws Exception {
        int databaseSizeBeforeUpdate = networkLayoutRepository.findAll().size();

        // Create the NetworkLayout
        NetworkLayoutDTO networkLayoutDTO = networkLayoutMapper.toDto(networkLayout);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNetworkLayoutMockMvc.perform(put("/api/network-layouts")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(networkLayoutDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NetworkLayout in the database
        List<NetworkLayout> networkLayoutList = networkLayoutRepository.findAll();
        assertThat(networkLayoutList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteNetworkLayout() throws Exception {
        // Initialize the database
        networkLayoutRepository.saveAndFlush(networkLayout);

        int databaseSizeBeforeDelete = networkLayoutRepository.findAll().size();

        // Delete the networkLayout
        restNetworkLayoutMockMvc.perform(delete("/api/network-layouts/{id}", networkLayout.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<NetworkLayout> networkLayoutList = networkLayoutRepository.findAll();
        assertThat(networkLayoutList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
