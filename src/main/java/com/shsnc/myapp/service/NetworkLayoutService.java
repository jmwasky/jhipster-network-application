package com.shsnc.myapp.service;

import com.shsnc.myapp.domain.NetworkLayout;
import com.shsnc.myapp.repository.NetworkLayoutRepository;
import com.shsnc.myapp.service.dto.NetworkLayoutDTO;
import com.shsnc.myapp.service.mapper.NetworkLayoutMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link NetworkLayout}.
 */
@Service
@Transactional
public class NetworkLayoutService {

    private final Logger log = LoggerFactory.getLogger(NetworkLayoutService.class);

    private final NetworkLayoutRepository networkLayoutRepository;

    private final NetworkLayoutMapper networkLayoutMapper;

    public NetworkLayoutService(NetworkLayoutRepository networkLayoutRepository, NetworkLayoutMapper networkLayoutMapper) {
        this.networkLayoutRepository = networkLayoutRepository;
        this.networkLayoutMapper = networkLayoutMapper;
    }

    /**
     * Save a networkLayout.
     *
     * @param networkLayoutDTO the entity to save.
     * @return the persisted entity.
     */
    public NetworkLayoutDTO save(NetworkLayoutDTO networkLayoutDTO) {
        log.debug("Request to save NetworkLayout : {}", networkLayoutDTO);
        NetworkLayout networkLayout = networkLayoutMapper.toEntity(networkLayoutDTO);
        networkLayout = networkLayoutRepository.save(networkLayout);
        return networkLayoutMapper.toDto(networkLayout);
    }

    /**
     * Get all the networkLayouts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<NetworkLayoutDTO> findAll(Pageable pageable) {
        log.debug("Request to get all NetworkLayouts");
        return networkLayoutRepository.findAll(pageable)
            .map(networkLayoutMapper::toDto);
    }

    /**
     * Get all the networkLayouts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<NetworkLayoutDTO> findAllByCondition(Pageable pageable) {
        log.debug("Request to get all NetworkLayouts");
        return networkLayoutRepository.findAll(pageable)
            .map(networkLayoutMapper::toDto);
    }


    /**
     * Get one networkLayout by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<NetworkLayoutDTO> findOne(Long id) {
        log.debug("Request to get NetworkLayout : {}", id);
        return networkLayoutRepository.findById(id)
            .map(networkLayoutMapper::toDto);
    }

    /**
     * Delete the networkLayout by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete NetworkLayout : {}", id);
        networkLayoutRepository.deleteById(id);
    }
}
