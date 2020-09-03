package com.shsnc.myapp.web.rest;

import com.shsnc.myapp.service.NetworkAssignModifyService;
import com.shsnc.myapp.web.rest.errors.BadRequestAlertException;
import com.shsnc.myapp.service.dto.NetworkAssignModifyDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.shsnc.myapp.domain.NetworkAssignModify}.
 */
@RestController
@RequestMapping("/api")
public class NetworkAssignModifyResource {

    private final Logger log = LoggerFactory.getLogger(NetworkAssignModifyResource.class);

    private static final String ENTITY_NAME = "jhipsterNetworkApplicationNetworkAssignModify";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NetworkAssignModifyService networkAssignModifyService;

    public NetworkAssignModifyResource(NetworkAssignModifyService networkAssignModifyService) {
        this.networkAssignModifyService = networkAssignModifyService;
    }

    /**
     * {@code POST  /network-assign-modifies} : Create a new networkAssignModify.
     *
     * @param networkAssignModifyDTO the networkAssignModifyDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new networkAssignModifyDTO, or with status {@code 400 (Bad Request)} if the networkAssignModify has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/network-assign-modifies")
    public ResponseEntity<NetworkAssignModifyDTO> createNetworkAssignModify(@Valid @RequestBody NetworkAssignModifyDTO networkAssignModifyDTO) throws URISyntaxException {
        log.debug("REST request to save NetworkAssignModify : {}", networkAssignModifyDTO);
        if (networkAssignModifyDTO.getId() != null) {
            throw new BadRequestAlertException("A new networkAssignModify cannot already have an ID", ENTITY_NAME, "idexists");
        }
        NetworkAssignModifyDTO result = networkAssignModifyService.save(networkAssignModifyDTO);
        return ResponseEntity.created(new URI("/api/network-assign-modifies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /network-assign-modifies} : Updates an existing networkAssignModify.
     *
     * @param networkAssignModifyDTO the networkAssignModifyDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated networkAssignModifyDTO,
     * or with status {@code 400 (Bad Request)} if the networkAssignModifyDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the networkAssignModifyDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/network-assign-modifies")
    public ResponseEntity<NetworkAssignModifyDTO> updateNetworkAssignModify(@Valid @RequestBody NetworkAssignModifyDTO networkAssignModifyDTO) throws URISyntaxException {
        log.debug("REST request to update NetworkAssignModify : {}", networkAssignModifyDTO);
        if (networkAssignModifyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        NetworkAssignModifyDTO result = networkAssignModifyService.save(networkAssignModifyDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, networkAssignModifyDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /network-assign-modifies} : get all the networkAssignModifies.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of networkAssignModifies in body.
     */
    @GetMapping("/network-assign-modifies")
    public ResponseEntity<List<NetworkAssignModifyDTO>> getAllNetworkAssignModifies(Pageable pageable) {
        log.debug("REST request to get a page of NetworkAssignModifies");
        Page<NetworkAssignModifyDTO> page = networkAssignModifyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /network-assign-modifies/:id} : get the "id" networkAssignModify.
     *
     * @param id the id of the networkAssignModifyDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the networkAssignModifyDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/network-assign-modifies/{id}")
    public ResponseEntity<NetworkAssignModifyDTO> getNetworkAssignModify(@PathVariable Long id) {
        log.debug("REST request to get NetworkAssignModify : {}", id);
        Optional<NetworkAssignModifyDTO> networkAssignModifyDTO = networkAssignModifyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(networkAssignModifyDTO);
    }

    /**
     * {@code DELETE  /network-assign-modifies/:id} : delete the "id" networkAssignModify.
     *
     * @param id the id of the networkAssignModifyDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/network-assign-modifies/{id}")
    public ResponseEntity<Void> deleteNetworkAssignModify(@PathVariable Long id) {
        log.debug("REST request to delete NetworkAssignModify : {}", id);
        networkAssignModifyService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
