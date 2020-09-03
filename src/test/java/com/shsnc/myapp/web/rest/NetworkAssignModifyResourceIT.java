package com.shsnc.myapp.web.rest;

import com.shsnc.myapp.JhipsterNetworkApplicationApp;
import com.shsnc.myapp.domain.NetworkAssignModify;
import com.shsnc.myapp.repository.NetworkAssignModifyRepository;
import com.shsnc.myapp.service.NetworkAssignModifyService;
import com.shsnc.myapp.service.dto.NetworkAssignModifyDTO;
import com.shsnc.myapp.service.mapper.NetworkAssignModifyMapper;

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

import com.shsnc.myapp.domain.enumeration.ModifySource;
import com.shsnc.myapp.domain.enumeration.ModifyType;
import com.shsnc.myapp.domain.enumeration.ModifySource;
/**
 * Integration tests for the {@link NetworkAssignModifyResource} REST controller.
 */
@SpringBootTest(classes = JhipsterNetworkApplicationApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class NetworkAssignModifyResourceIT {

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final Integer DEFAULT_UPDATE_TIME = 1;
    private static final Integer UPDATED_UPDATE_TIME = 2;

    private static final ModifySource DEFAULT_MODIFY_SOURCE = ModifySource.ITSM;
    private static final ModifySource UPDATED_MODIFY_SOURCE = ModifySource.IPMANAGER;

    private static final Integer DEFAULT_EXTERNAL_ID = 1;
    private static final Integer UPDATED_EXTERNAL_ID = 2;

    private static final ModifyType DEFAULT_MODIFY_TYPE = ModifyType.IPAPPLY;
    private static final ModifyType UPDATED_MODIFY_TYPE = ModifyType.IPMODIFY;

    private static final BigDecimal DEFAULT_MODIFIED_COUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_MODIFIED_COUNT = new BigDecimal(2);

    private static final ModifySource DEFAULT_MODIFY_STATUS = ModifySource.ITSM;
    private static final ModifySource UPDATED_MODIFY_STATUS = ModifySource.IPMANAGER;

    private static final Integer DEFAULT_ORDER_DETAIL_ID = 1;
    private static final Integer UPDATED_ORDER_DETAIL_ID = 2;

    private static final Integer DEFAULT_MANAGER_ID = 1;
    private static final Integer UPDATED_MANAGER_ID = 2;

    private static final String DEFAULT_MANAGER_VALUE = "AAAAAAAAAA";
    private static final String UPDATED_MANAGER_VALUE = "BBBBBBBBBB";

    private static final Integer DEFAULT_SYSTEM_ID = 1;
    private static final Integer UPDATED_SYSTEM_ID = 2;

    private static final String DEFAULT_SYSTEM_VALUE = "AAAAAAAAAA";
    private static final String UPDATED_SYSTEM_VALUE = "BBBBBBBBBB";

    private static final Integer DEFAULT_DEPARTMENT_ID = 1;
    private static final Integer UPDATED_DEPARTMENT_ID = 2;

    private static final String DEFAULT_DEPARTMENT_VALUE = "AAAAAAAAAA";
    private static final String UPDATED_DEPARTMENT_VALUE = "BBBBBBBBBB";

    @Autowired
    private NetworkAssignModifyRepository networkAssignModifyRepository;

    @Autowired
    private NetworkAssignModifyMapper networkAssignModifyMapper;

    @Autowired
    private NetworkAssignModifyService networkAssignModifyService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restNetworkAssignModifyMockMvc;

    private NetworkAssignModify networkAssignModify;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NetworkAssignModify createEntity(EntityManager em) {
        NetworkAssignModify networkAssignModify = new NetworkAssignModify()
            .title(DEFAULT_TITLE)
            .updateTime(DEFAULT_UPDATE_TIME)
            .modifySource(DEFAULT_MODIFY_SOURCE)
            .externalId(DEFAULT_EXTERNAL_ID)
            .modifyType(DEFAULT_MODIFY_TYPE)
            .modifiedCount(DEFAULT_MODIFIED_COUNT)
            .modifyStatus(DEFAULT_MODIFY_STATUS)
            .orderDetailId(DEFAULT_ORDER_DETAIL_ID)
            .managerId(DEFAULT_MANAGER_ID)
            .managerValue(DEFAULT_MANAGER_VALUE)
            .systemId(DEFAULT_SYSTEM_ID)
            .systemValue(DEFAULT_SYSTEM_VALUE)
            .departmentId(DEFAULT_DEPARTMENT_ID)
            .departmentValue(DEFAULT_DEPARTMENT_VALUE);
        return networkAssignModify;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NetworkAssignModify createUpdatedEntity(EntityManager em) {
        NetworkAssignModify networkAssignModify = new NetworkAssignModify()
            .title(UPDATED_TITLE)
            .updateTime(UPDATED_UPDATE_TIME)
            .modifySource(UPDATED_MODIFY_SOURCE)
            .externalId(UPDATED_EXTERNAL_ID)
            .modifyType(UPDATED_MODIFY_TYPE)
            .modifiedCount(UPDATED_MODIFIED_COUNT)
            .modifyStatus(UPDATED_MODIFY_STATUS)
            .orderDetailId(UPDATED_ORDER_DETAIL_ID)
            .managerId(UPDATED_MANAGER_ID)
            .managerValue(UPDATED_MANAGER_VALUE)
            .systemId(UPDATED_SYSTEM_ID)
            .systemValue(UPDATED_SYSTEM_VALUE)
            .departmentId(UPDATED_DEPARTMENT_ID)
            .departmentValue(UPDATED_DEPARTMENT_VALUE);
        return networkAssignModify;
    }

    @BeforeEach
    public void initTest() {
        networkAssignModify = createEntity(em);
    }

    @Test
    @Transactional
    public void createNetworkAssignModify() throws Exception {
        int databaseSizeBeforeCreate = networkAssignModifyRepository.findAll().size();
        // Create the NetworkAssignModify
        NetworkAssignModifyDTO networkAssignModifyDTO = networkAssignModifyMapper.toDto(networkAssignModify);
        restNetworkAssignModifyMockMvc.perform(post("/api/network-assign-modifies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(networkAssignModifyDTO)))
            .andExpect(status().isCreated());

        // Validate the NetworkAssignModify in the database
        List<NetworkAssignModify> networkAssignModifyList = networkAssignModifyRepository.findAll();
        assertThat(networkAssignModifyList).hasSize(databaseSizeBeforeCreate + 1);
        NetworkAssignModify testNetworkAssignModify = networkAssignModifyList.get(networkAssignModifyList.size() - 1);
        assertThat(testNetworkAssignModify.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testNetworkAssignModify.getUpdateTime()).isEqualTo(DEFAULT_UPDATE_TIME);
        assertThat(testNetworkAssignModify.getModifySource()).isEqualTo(DEFAULT_MODIFY_SOURCE);
        assertThat(testNetworkAssignModify.getExternalId()).isEqualTo(DEFAULT_EXTERNAL_ID);
        assertThat(testNetworkAssignModify.getModifyType()).isEqualTo(DEFAULT_MODIFY_TYPE);
        assertThat(testNetworkAssignModify.getModifiedCount()).isEqualTo(DEFAULT_MODIFIED_COUNT);
        assertThat(testNetworkAssignModify.getModifyStatus()).isEqualTo(DEFAULT_MODIFY_STATUS);
        assertThat(testNetworkAssignModify.getOrderDetailId()).isEqualTo(DEFAULT_ORDER_DETAIL_ID);
        assertThat(testNetworkAssignModify.getManagerId()).isEqualTo(DEFAULT_MANAGER_ID);
        assertThat(testNetworkAssignModify.getManagerValue()).isEqualTo(DEFAULT_MANAGER_VALUE);
        assertThat(testNetworkAssignModify.getSystemId()).isEqualTo(DEFAULT_SYSTEM_ID);
        assertThat(testNetworkAssignModify.getSystemValue()).isEqualTo(DEFAULT_SYSTEM_VALUE);
        assertThat(testNetworkAssignModify.getDepartmentId()).isEqualTo(DEFAULT_DEPARTMENT_ID);
        assertThat(testNetworkAssignModify.getDepartmentValue()).isEqualTo(DEFAULT_DEPARTMENT_VALUE);
    }

    @Test
    @Transactional
    public void createNetworkAssignModifyWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = networkAssignModifyRepository.findAll().size();

        // Create the NetworkAssignModify with an existing ID
        networkAssignModify.setId(1L);
        NetworkAssignModifyDTO networkAssignModifyDTO = networkAssignModifyMapper.toDto(networkAssignModify);

        // An entity with an existing ID cannot be created, so this API call must fail
        restNetworkAssignModifyMockMvc.perform(post("/api/network-assign-modifies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(networkAssignModifyDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NetworkAssignModify in the database
        List<NetworkAssignModify> networkAssignModifyList = networkAssignModifyRepository.findAll();
        assertThat(networkAssignModifyList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllNetworkAssignModifies() throws Exception {
        // Initialize the database
        networkAssignModifyRepository.saveAndFlush(networkAssignModify);

        // Get all the networkAssignModifyList
        restNetworkAssignModifyMockMvc.perform(get("/api/network-assign-modifies?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(networkAssignModify.getId().intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME)))
            .andExpect(jsonPath("$.[*].modifySource").value(hasItem(DEFAULT_MODIFY_SOURCE.toString())))
            .andExpect(jsonPath("$.[*].externalId").value(hasItem(DEFAULT_EXTERNAL_ID)))
            .andExpect(jsonPath("$.[*].modifyType").value(hasItem(DEFAULT_MODIFY_TYPE.toString())))
            .andExpect(jsonPath("$.[*].modifiedCount").value(hasItem(DEFAULT_MODIFIED_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].modifyStatus").value(hasItem(DEFAULT_MODIFY_STATUS.toString())))
            .andExpect(jsonPath("$.[*].orderDetailId").value(hasItem(DEFAULT_ORDER_DETAIL_ID)))
            .andExpect(jsonPath("$.[*].managerId").value(hasItem(DEFAULT_MANAGER_ID)))
            .andExpect(jsonPath("$.[*].managerValue").value(hasItem(DEFAULT_MANAGER_VALUE)))
            .andExpect(jsonPath("$.[*].systemId").value(hasItem(DEFAULT_SYSTEM_ID)))
            .andExpect(jsonPath("$.[*].systemValue").value(hasItem(DEFAULT_SYSTEM_VALUE)))
            .andExpect(jsonPath("$.[*].departmentId").value(hasItem(DEFAULT_DEPARTMENT_ID)))
            .andExpect(jsonPath("$.[*].departmentValue").value(hasItem(DEFAULT_DEPARTMENT_VALUE)));
    }
    
    @Test
    @Transactional
    public void getNetworkAssignModify() throws Exception {
        // Initialize the database
        networkAssignModifyRepository.saveAndFlush(networkAssignModify);

        // Get the networkAssignModify
        restNetworkAssignModifyMockMvc.perform(get("/api/network-assign-modifies/{id}", networkAssignModify.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(networkAssignModify.getId().intValue()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME))
            .andExpect(jsonPath("$.modifySource").value(DEFAULT_MODIFY_SOURCE.toString()))
            .andExpect(jsonPath("$.externalId").value(DEFAULT_EXTERNAL_ID))
            .andExpect(jsonPath("$.modifyType").value(DEFAULT_MODIFY_TYPE.toString()))
            .andExpect(jsonPath("$.modifiedCount").value(DEFAULT_MODIFIED_COUNT.intValue()))
            .andExpect(jsonPath("$.modifyStatus").value(DEFAULT_MODIFY_STATUS.toString()))
            .andExpect(jsonPath("$.orderDetailId").value(DEFAULT_ORDER_DETAIL_ID))
            .andExpect(jsonPath("$.managerId").value(DEFAULT_MANAGER_ID))
            .andExpect(jsonPath("$.managerValue").value(DEFAULT_MANAGER_VALUE))
            .andExpect(jsonPath("$.systemId").value(DEFAULT_SYSTEM_ID))
            .andExpect(jsonPath("$.systemValue").value(DEFAULT_SYSTEM_VALUE))
            .andExpect(jsonPath("$.departmentId").value(DEFAULT_DEPARTMENT_ID))
            .andExpect(jsonPath("$.departmentValue").value(DEFAULT_DEPARTMENT_VALUE));
    }
    @Test
    @Transactional
    public void getNonExistingNetworkAssignModify() throws Exception {
        // Get the networkAssignModify
        restNetworkAssignModifyMockMvc.perform(get("/api/network-assign-modifies/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateNetworkAssignModify() throws Exception {
        // Initialize the database
        networkAssignModifyRepository.saveAndFlush(networkAssignModify);

        int databaseSizeBeforeUpdate = networkAssignModifyRepository.findAll().size();

        // Update the networkAssignModify
        NetworkAssignModify updatedNetworkAssignModify = networkAssignModifyRepository.findById(networkAssignModify.getId()).get();
        // Disconnect from session so that the updates on updatedNetworkAssignModify are not directly saved in db
        em.detach(updatedNetworkAssignModify);
        updatedNetworkAssignModify
            .title(UPDATED_TITLE)
            .updateTime(UPDATED_UPDATE_TIME)
            .modifySource(UPDATED_MODIFY_SOURCE)
            .externalId(UPDATED_EXTERNAL_ID)
            .modifyType(UPDATED_MODIFY_TYPE)
            .modifiedCount(UPDATED_MODIFIED_COUNT)
            .modifyStatus(UPDATED_MODIFY_STATUS)
            .orderDetailId(UPDATED_ORDER_DETAIL_ID)
            .managerId(UPDATED_MANAGER_ID)
            .managerValue(UPDATED_MANAGER_VALUE)
            .systemId(UPDATED_SYSTEM_ID)
            .systemValue(UPDATED_SYSTEM_VALUE)
            .departmentId(UPDATED_DEPARTMENT_ID)
            .departmentValue(UPDATED_DEPARTMENT_VALUE);
        NetworkAssignModifyDTO networkAssignModifyDTO = networkAssignModifyMapper.toDto(updatedNetworkAssignModify);

        restNetworkAssignModifyMockMvc.perform(put("/api/network-assign-modifies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(networkAssignModifyDTO)))
            .andExpect(status().isOk());

        // Validate the NetworkAssignModify in the database
        List<NetworkAssignModify> networkAssignModifyList = networkAssignModifyRepository.findAll();
        assertThat(networkAssignModifyList).hasSize(databaseSizeBeforeUpdate);
        NetworkAssignModify testNetworkAssignModify = networkAssignModifyList.get(networkAssignModifyList.size() - 1);
        assertThat(testNetworkAssignModify.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testNetworkAssignModify.getUpdateTime()).isEqualTo(UPDATED_UPDATE_TIME);
        assertThat(testNetworkAssignModify.getModifySource()).isEqualTo(UPDATED_MODIFY_SOURCE);
        assertThat(testNetworkAssignModify.getExternalId()).isEqualTo(UPDATED_EXTERNAL_ID);
        assertThat(testNetworkAssignModify.getModifyType()).isEqualTo(UPDATED_MODIFY_TYPE);
        assertThat(testNetworkAssignModify.getModifiedCount()).isEqualTo(UPDATED_MODIFIED_COUNT);
        assertThat(testNetworkAssignModify.getModifyStatus()).isEqualTo(UPDATED_MODIFY_STATUS);
        assertThat(testNetworkAssignModify.getOrderDetailId()).isEqualTo(UPDATED_ORDER_DETAIL_ID);
        assertThat(testNetworkAssignModify.getManagerId()).isEqualTo(UPDATED_MANAGER_ID);
        assertThat(testNetworkAssignModify.getManagerValue()).isEqualTo(UPDATED_MANAGER_VALUE);
        assertThat(testNetworkAssignModify.getSystemId()).isEqualTo(UPDATED_SYSTEM_ID);
        assertThat(testNetworkAssignModify.getSystemValue()).isEqualTo(UPDATED_SYSTEM_VALUE);
        assertThat(testNetworkAssignModify.getDepartmentId()).isEqualTo(UPDATED_DEPARTMENT_ID);
        assertThat(testNetworkAssignModify.getDepartmentValue()).isEqualTo(UPDATED_DEPARTMENT_VALUE);
    }

    @Test
    @Transactional
    public void updateNonExistingNetworkAssignModify() throws Exception {
        int databaseSizeBeforeUpdate = networkAssignModifyRepository.findAll().size();

        // Create the NetworkAssignModify
        NetworkAssignModifyDTO networkAssignModifyDTO = networkAssignModifyMapper.toDto(networkAssignModify);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNetworkAssignModifyMockMvc.perform(put("/api/network-assign-modifies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(networkAssignModifyDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NetworkAssignModify in the database
        List<NetworkAssignModify> networkAssignModifyList = networkAssignModifyRepository.findAll();
        assertThat(networkAssignModifyList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteNetworkAssignModify() throws Exception {
        // Initialize the database
        networkAssignModifyRepository.saveAndFlush(networkAssignModify);

        int databaseSizeBeforeDelete = networkAssignModifyRepository.findAll().size();

        // Delete the networkAssignModify
        restNetworkAssignModifyMockMvc.perform(delete("/api/network-assign-modifies/{id}", networkAssignModify.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<NetworkAssignModify> networkAssignModifyList = networkAssignModifyRepository.findAll();
        assertThat(networkAssignModifyList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
