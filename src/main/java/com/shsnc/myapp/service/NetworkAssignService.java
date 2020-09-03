package com.shsnc.myapp.service;

import com.shsnc.myapp.domain.NetworkAssign;
import com.shsnc.myapp.repository.NetworkAssignRepository;
import com.shsnc.myapp.service.dto.NetworkAssignDTO;
import com.shsnc.myapp.service.mapper.NetworkAssignMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link NetworkAssign}.
 */
@Service
@Transactional
public class NetworkAssignService {

    private final Logger log = LoggerFactory.getLogger(NetworkAssignService.class);

    private final NetworkAssignRepository networkAssignRepository;

    private final NetworkAssignMapper networkAssignMapper;

    public NetworkAssignService(NetworkAssignRepository networkAssignRepository, NetworkAssignMapper networkAssignMapper) {
        this.networkAssignRepository = networkAssignRepository;
        this.networkAssignMapper = networkAssignMapper;
    }

    /**
     * Save a networkAssign.
     *
     * @param networkAssignDTO the entity to save.
     * @return the persisted entity.
     */
    public NetworkAssignDTO save(NetworkAssignDTO networkAssignDTO) {
        log.debug("Request to save NetworkAssign : {}", networkAssignDTO);
        NetworkAssign networkAssign = networkAssignMapper.toEntity(networkAssignDTO);
        networkAssign = networkAssignRepository.save(networkAssign);
        return networkAssignMapper.toDto(networkAssign);
    }

    /**
     * Get all the networkAssigns.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<NetworkAssignDTO> findAll(Pageable pageable) {
        log.debug("Request to get all NetworkAssigns");
        return networkAssignRepository.findAll(pageable)
            .map(networkAssignMapper::toDto);
    }


    /**
     * Get one networkAssign by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<NetworkAssignDTO> findOne(Long id) {
        log.debug("Request to get NetworkAssign : {}", id);
        return networkAssignRepository.findById(id)
            .map(networkAssignMapper::toDto);
    }

    /**
     * Delete the networkAssign by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete NetworkAssign : {}", id);
        networkAssignRepository.deleteById(id);
    }
}
