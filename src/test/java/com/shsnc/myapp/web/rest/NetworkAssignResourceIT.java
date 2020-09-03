package com.shsnc.myapp.web.rest;

import com.shsnc.myapp.JhipsterNetworkApplicationApp;
import com.shsnc.myapp.domain.NetworkAssign;
import com.shsnc.myapp.repository.NetworkAssignRepository;
import com.shsnc.myapp.service.NetworkAssignService;
import com.shsnc.myapp.service.dto.NetworkAssignDTO;
import com.shsnc.myapp.service.mapper.NetworkAssignMapper;

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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.shsnc.myapp.domain.enumeration.AllocateStatus;
/**
 * Integration tests for the {@link NetworkAssignResource} REST controller.
 */
@SpringBootTest(classes = JhipsterNetworkApplicationApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class NetworkAssignResourceIT {

    private static final Long DEFAULT_AUTO_ID = 1L;
    private static final Long UPDATED_AUTO_ID = 2L;

    private static final String DEFAULT_IP_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_IP_ADDRESS = "BBBBBBBBBB";

    private static final Integer DEFAULT_DEPARTMENT_ID = 1;
    private static final Integer UPDATED_DEPARTMENT_ID = 2;

    private static final String DEFAULT_DEPARTMENT_VALUE = "AAAAAAAAAA";
    private static final String UPDATED_DEPARTMENT_VALUE = "BBBBBBBBBB";

    private static final Integer DEFAULT_SYSTEM_ID = 1;
    private static final Integer UPDATED_SYSTEM_ID = 2;

    private static final String DEFAULT_SYSTEM_VALUE = "AAAAAAAAAA";
    private static final String UPDATED_SYSTEM_VALUE = "BBBBBBBBBB";

    private static final Integer DEFAULT_MANAGER_ID = 1;
    private static final Integer UPDATED_MANAGER_ID = 2;

    private static final String DEFAULT_MANAGER_VALUE = "AAAAAAAAAA";
    private static final String UPDATED_MANAGER_VALUE = "BBBBBBBBBB";

    private static final String DEFAULT_RESOURCE_IDS = "AAAAAAAAAA";
    private static final String UPDATED_RESOURCE_IDS = "BBBBBBBBBB";

    private static final AllocateStatus DEFAULT_ALLOCATE_STATUS = AllocateStatus.ENABLE;
    private static final AllocateStatus UPDATED_ALLOCATE_STATUS = AllocateStatus.DISABLE;

    private static final String DEFAULT_IP_DESCRIBE = "AAAAAAAAAA";
    private static final String UPDATED_IP_DESCRIBE = "BBBBBBBBBB";

    private static final Integer DEFAULT_UPDATE_TIME = 1;
    private static final Integer UPDATED_UPDATE_TIME = 2;

    @Autowired
    private NetworkAssignRepository networkAssignRepository;

    @Autowired
    private NetworkAssignMapper networkAssignMapper;

    @Autowired
    private NetworkAssignService networkAssignService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restNetworkAssignMockMvc;

    private NetworkAssign networkAssign;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NetworkAssign createEntity(EntityManager em) {
        NetworkAssign networkAssign = new NetworkAssign()
            .autoId(DEFAULT_AUTO_ID)
            .ipAddress(DEFAULT_IP_ADDRESS)
            .departmentId(DEFAULT_DEPARTMENT_ID)
            .departmentValue(DEFAULT_DEPARTMENT_VALUE)
            .systemId(DEFAULT_SYSTEM_ID)
            .systemValue(DEFAULT_SYSTEM_VALUE)
            .managerId(DEFAULT_MANAGER_ID)
            .managerValue(DEFAULT_MANAGER_VALUE)
            .resourceIds(DEFAULT_RESOURCE_IDS)
            .allocateStatus(DEFAULT_ALLOCATE_STATUS)
            .ipDescribe(DEFAULT_IP_DESCRIBE)
            .updateTime(DEFAULT_UPDATE_TIME);
        return networkAssign;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NetworkAssign createUpdatedEntity(EntityManager em) {
        NetworkAssign networkAssign = new NetworkAssign()
            .autoId(UPDATED_AUTO_ID)
            .ipAddress(UPDATED_IP_ADDRESS)
            .departmentId(UPDATED_DEPARTMENT_ID)
            .departmentValue(UPDATED_DEPARTMENT_VALUE)
            .systemId(UPDATED_SYSTEM_ID)
            .systemValue(UPDATED_SYSTEM_VALUE)
            .managerId(UPDATED_MANAGER_ID)
            .managerValue(UPDATED_MANAGER_VALUE)
            .resourceIds(UPDATED_RESOURCE_IDS)
            .allocateStatus(UPDATED_ALLOCATE_STATUS)
            .ipDescribe(UPDATED_IP_DESCRIBE)
            .updateTime(UPDATED_UPDATE_TIME);
        return networkAssign;
    }

    @BeforeEach
    public void initTest() {
        networkAssign = createEntity(em);
    }

    @Test
    @Transactional
    public void createNetworkAssign() throws Exception {
        int databaseSizeBeforeCreate = networkAssignRepository.findAll().size();
        // Create the NetworkAssign
        NetworkAssignDTO networkAssignDTO = networkAssignMapper.toDto(networkAssign);
        restNetworkAssignMockMvc.perform(post("/api/network-assigns")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(networkAssignDTO)))
            .andExpect(status().isCreated());

        // Validate the NetworkAssign in the database
        List<NetworkAssign> networkAssignList = networkAssignRepository.findAll();
        assertThat(networkAssignList).hasSize(databaseSizeBeforeCreate + 1);
        NetworkAssign testNetworkAssign = networkAssignList.get(networkAssignList.size() - 1);
        assertThat(testNetworkAssign.getAutoId()).isEqualTo(DEFAULT_AUTO_ID);
        assertThat(testNetworkAssign.getIpAddress()).isEqualTo(DEFAULT_IP_ADDRESS);
        assertThat(testNetworkAssign.getDepartmentId()).isEqualTo(DEFAULT_DEPARTMENT_ID);
        assertThat(testNetworkAssign.getDepartmentValue()).isEqualTo(DEFAULT_DEPARTMENT_VALUE);
        assertThat(testNetworkAssign.getSystemId()).isEqualTo(DEFAULT_SYSTEM_ID);
        assertThat(testNetworkAssign.getSystemValue()).isEqualTo(DEFAULT_SYSTEM_VALUE);
        assertThat(testNetworkAssign.getManagerId()).isEqualTo(DEFAULT_MANAGER_ID);
        assertThat(testNetworkAssign.getManagerValue()).isEqualTo(DEFAULT_MANAGER_VALUE);
        assertThat(testNetworkAssign.getResourceIds()).isEqualTo(DEFAULT_RESOURCE_IDS);
        assertThat(testNetworkAssign.getAllocateStatus()).isEqualTo(DEFAULT_ALLOCATE_STATUS);
        assertThat(testNetworkAssign.getIpDescribe()).isEqualTo(DEFAULT_IP_DESCRIBE);
        assertThat(testNetworkAssign.getUpdateTime()).isEqualTo(DEFAULT_UPDATE_TIME);
    }

    @Test
    @Transactional
    public void createNetworkAssignWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = networkAssignRepository.findAll().size();

        // Create the NetworkAssign with an existing ID
        networkAssign.setId(1L);
        NetworkAssignDTO networkAssignDTO = networkAssignMapper.toDto(networkAssign);

        // An entity with an existing ID cannot be created, so this API call must fail
        restNetworkAssignMockMvc.perform(post("/api/network-assigns")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(networkAssignDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NetworkAssign in the database
        List<NetworkAssign> networkAssignList = networkAssignRepository.findAll();
        assertThat(networkAssignList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllNetworkAssigns() throws Exception {
        // Initialize the database
        networkAssignRepository.saveAndFlush(networkAssign);

        // Get all the networkAssignList
        restNetworkAssignMockMvc.perform(get("/api/network-assigns?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(networkAssign.getId().intValue())))
            .andExpect(jsonPath("$.[*].autoId").value(hasItem(DEFAULT_AUTO_ID.intValue())))
            .andExpect(jsonPath("$.[*].ipAddress").value(hasItem(DEFAULT_IP_ADDRESS)))
            .andExpect(jsonPath("$.[*].departmentId").value(hasItem(DEFAULT_DEPARTMENT_ID)))
            .andExpect(jsonPath("$.[*].departmentValue").value(hasItem(DEFAULT_DEPARTMENT_VALUE)))
            .andExpect(jsonPath("$.[*].systemId").value(hasItem(DEFAULT_SYSTEM_ID)))
            .andExpect(jsonPath("$.[*].systemValue").value(hasItem(DEFAULT_SYSTEM_VALUE)))
            .andExpect(jsonPath("$.[*].managerId").value(hasItem(DEFAULT_MANAGER_ID)))
            .andExpect(jsonPath("$.[*].managerValue").value(hasItem(DEFAULT_MANAGER_VALUE)))
            .andExpect(jsonPath("$.[*].resourceIds").value(hasItem(DEFAULT_RESOURCE_IDS)))
            .andExpect(jsonPath("$.[*].allocateStatus").value(hasItem(DEFAULT_ALLOCATE_STATUS.toString())))
            .andExpect(jsonPath("$.[*].ipDescribe").value(hasItem(DEFAULT_IP_DESCRIBE)))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME)));
    }
    
    @Test
    @Transactional
    public void getNetworkAssign() throws Exception {
        // Initialize the database
        networkAssignRepository.saveAndFlush(networkAssign);

        // Get the networkAssign
        restNetworkAssignMockMvc.perform(get("/api/network-assigns/{id}", networkAssign.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(networkAssign.getId().intValue()))
            .andExpect(jsonPath("$.autoId").value(DEFAULT_AUTO_ID.intValue()))
            .andExpect(jsonPath("$.ipAddress").value(DEFAULT_IP_ADDRESS))
            .andExpect(jsonPath("$.departmentId").value(DEFAULT_DEPARTMENT_ID))
            .andExpect(jsonPath("$.departmentValue").value(DEFAULT_DEPARTMENT_VALUE))
            .andExpect(jsonPath("$.systemId").value(DEFAULT_SYSTEM_ID))
            .andExpect(jsonPath("$.systemValue").value(DEFAULT_SYSTEM_VALUE))
            .andExpect(jsonPath("$.managerId").value(DEFAULT_MANAGER_ID))
            .andExpect(jsonPath("$.managerValue").value(DEFAULT_MANAGER_VALUE))
            .andExpect(jsonPath("$.resourceIds").value(DEFAULT_RESOURCE_IDS))
            .andExpect(jsonPath("$.allocateStatus").value(DEFAULT_ALLOCATE_STATUS.toString()))
            .andExpect(jsonPath("$.ipDescribe").value(DEFAULT_IP_DESCRIBE))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME));
    }
    @Test
    @Transactional
    public void getNonExistingNetworkAssign() throws Exception {
        // Get the networkAssign
        restNetworkAssignMockMvc.perform(get("/api/network-assigns/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateNetworkAssign() throws Exception {
        // Initialize the database
        networkAssignRepository.saveAndFlush(networkAssign);

        int databaseSizeBeforeUpdate = networkAssignRepository.findAll().size();

        // Update the networkAssign
        NetworkAssign updatedNetworkAssign = networkAssignRepository.findById(networkAssign.getId()).get();
        // Disconnect from session so that the updates on updatedNetworkAssign are not directly saved in db
        em.detach(updatedNetworkAssign);
        updatedNetworkAssign
            .autoId(UPDATED_AUTO_ID)
            .ipAddress(UPDATED_IP_ADDRESS)
            .departmentId(UPDATED_DEPARTMENT_ID)
            .departmentValue(UPDATED_DEPARTMENT_VALUE)
            .systemId(UPDATED_SYSTEM_ID)
            .systemValue(UPDATED_SYSTEM_VALUE)
            .managerId(UPDATED_MANAGER_ID)
            .managerValue(UPDATED_MANAGER_VALUE)
            .resourceIds(UPDATED_RESOURCE_IDS)
            .allocateStatus(UPDATED_ALLOCATE_STATUS)
            .ipDescribe(UPDATED_IP_DESCRIBE)
            .updateTime(UPDATED_UPDATE_TIME);
        NetworkAssignDTO networkAssignDTO = networkAssignMapper.toDto(updatedNetworkAssign);

        restNetworkAssignMockMvc.perform(put("/api/network-assigns")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(networkAssignDTO)))
            .andExpect(status().isOk());

        // Validate the NetworkAssign in the database
        List<NetworkAssign> networkAssignList = networkAssignRepository.findAll();
        assertThat(networkAssignList).hasSize(databaseSizeBeforeUpdate);
        NetworkAssign testNetworkAssign = networkAssignList.get(networkAssignList.size() - 1);
        assertThat(testNetworkAssign.getAutoId()).isEqualTo(UPDATED_AUTO_ID);
        assertThat(testNetworkAssign.getIpAddress()).isEqualTo(UPDATED_IP_ADDRESS);
        assertThat(testNetworkAssign.getDepartmentId()).isEqualTo(UPDATED_DEPARTMENT_ID);
        assertThat(testNetworkAssign.getDepartmentValue()).isEqualTo(UPDATED_DEPARTMENT_VALUE);
        assertThat(testNetworkAssign.getSystemId()).isEqualTo(UPDATED_SYSTEM_ID);
        assertThat(testNetworkAssign.getSystemValue()).isEqualTo(UPDATED_SYSTEM_VALUE);
        assertThat(testNetworkAssign.getManagerId()).isEqualTo(UPDATED_MANAGER_ID);
        assertThat(testNetworkAssign.getManagerValue()).isEqualTo(UPDATED_MANAGER_VALUE);
        assertThat(testNetworkAssign.getResourceIds()).isEqualTo(UPDATED_RESOURCE_IDS);
        assertThat(testNetworkAssign.getAllocateStatus()).isEqualTo(UPDATED_ALLOCATE_STATUS);
        assertThat(testNetworkAssign.getIpDescribe()).isEqualTo(UPDATED_IP_DESCRIBE);
        assertThat(testNetworkAssign.getUpdateTime()).isEqualTo(UPDATED_UPDATE_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingNetworkAssign() throws Exception {
        int databaseSizeBeforeUpdate = networkAssignRepository.findAll().size();

        // Create the NetworkAssign
        NetworkAssignDTO networkAssignDTO = networkAssignMapper.toDto(networkAssign);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNetworkAssignMockMvc.perform(put("/api/network-assigns")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(networkAssignDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NetworkAssign in the database
        List<NetworkAssign> networkAssignList = networkAssignRepository.findAll();
        assertThat(networkAssignList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteNetworkAssign() throws Exception {
        // Initialize the database
        networkAssignRepository.saveAndFlush(networkAssign);

        int databaseSizeBeforeDelete = networkAssignRepository.findAll().size();

        // Delete the networkAssign
        restNetworkAssignMockMvc.perform(delete("/api/network-assigns/{id}", networkAssign.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<NetworkAssign> networkAssignList = networkAssignRepository.findAll();
        assertThat(networkAssignList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
