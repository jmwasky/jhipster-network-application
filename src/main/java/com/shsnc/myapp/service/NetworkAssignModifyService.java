package com.shsnc.myapp.service;

import com.shsnc.myapp.domain.NetworkAssignModify;
import com.shsnc.myapp.repository.NetworkAssignModifyRepository;
import com.shsnc.myapp.service.dto.NetworkAssignModifyDTO;
import com.shsnc.myapp.service.mapper.NetworkAssignModifyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link NetworkAssignModify}.
 */
@Service
@Transactional
public class NetworkAssignModifyService {

    private final Logger log = LoggerFactory.getLogger(NetworkAssignModifyService.class);

    private final NetworkAssignModifyRepository networkAssignModifyRepository;

    private final NetworkAssignModifyMapper networkAssignModifyMapper;

    public NetworkAssignModifyService(NetworkAssignModifyRepository networkAssignModifyRepository, NetworkAssignModifyMapper networkAssignModifyMapper) {
        this.networkAssignModifyRepository = networkAssignModifyRepository;
        this.networkAssignModifyMapper = networkAssignModifyMapper;
    }

    /**
     * Save a networkAssignModify.
     *
     * @param networkAssignModifyDTO the entity to save.
     * @return the persisted entity.
     */
    public NetworkAssignModifyDTO save(NetworkAssignModifyDTO networkAssignModifyDTO) {
        log.debug("Request to save NetworkAssignModify : {}", networkAssignModifyDTO);
        NetworkAssignModify networkAssignModify = networkAssignModifyMapper.toEntity(networkAssignModifyDTO);
        networkAssignModify = networkAssignModifyRepository.save(networkAssignModify);
        return networkAssignModifyMapper.toDto(networkAssignModify);
    }

    /**
     * Get all the networkAssignModifies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<NetworkAssignModifyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all NetworkAssignModifies");
        return networkAssignModifyRepository.findAll(pageable)
            .map(networkAssignModifyMapper::toDto);
    }


    /**
     * Get one networkAssignModify by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<NetworkAssignModifyDTO> findOne(Long id) {
        log.debug("Request to get NetworkAssignModify : {}", id);
        return networkAssignModifyRepository.findById(id)
            .map(networkAssignModifyMapper::toDto);
    }

    /**
     * Delete the networkAssignModify by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete NetworkAssignModify : {}", id);
        networkAssignModifyRepository.deleteById(id);
    }
}
