package com.shsnc.myapp.web.rest;

import com.shsnc.myapp.service.NetworkAssignService;
import com.shsnc.myapp.web.rest.errors.BadRequestAlertException;
import com.shsnc.myapp.service.dto.NetworkAssignDTO;

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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.shsnc.myapp.domain.NetworkAssign}.
 */
@RestController
@RequestMapping("/api")
public class NetworkAssignResource {

    private final Logger log = LoggerFactory.getLogger(NetworkAssignResource.class);

    private static final String ENTITY_NAME = "jhipsterNetworkApplicationNetworkAssign";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NetworkAssignService networkAssignService;

    public NetworkAssignResource(NetworkAssignService networkAssignService) {
        this.networkAssignService = networkAssignService;
    }

    /**
     * {@code POST  /network-assigns} : Create a new networkAssign.
     *
     * @param networkAssignDTO the networkAssignDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new networkAssignDTO, or with status {@code 400 (Bad Request)} if the networkAssign has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/network-assigns")
    public ResponseEntity<NetworkAssignDTO> createNetworkAssign(@RequestBody NetworkAssignDTO networkAssignDTO) throws URISyntaxException {
        log.debug("REST request to save NetworkAssign : {}", networkAssignDTO);
        if (networkAssignDTO.getId() != null) {
            throw new BadRequestAlertException("A new networkAssign cannot already have an ID", ENTITY_NAME, "idexists");
        }
        NetworkAssignDTO result = networkAssignService.save(networkAssignDTO);
        return ResponseEntity.created(new URI("/api/network-assigns/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /network-assigns} : Updates an existing networkAssign.
     *
     * @param networkAssignDTO the networkAssignDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated networkAssignDTO,
     * or with status {@code 400 (Bad Request)} if the networkAssignDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the networkAssignDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/network-assigns")
    public ResponseEntity<NetworkAssignDTO> updateNetworkAssign(@RequestBody NetworkAssignDTO networkAssignDTO) throws URISyntaxException {
        log.debug("REST request to update NetworkAssign : {}", networkAssignDTO);
        if (networkAssignDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        NetworkAssignDTO result = networkAssignService.save(networkAssignDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, networkAssignDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /network-assigns} : get all the networkAssigns.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of networkAssigns in body.
     */
    @GetMapping("/network-assigns")
    public ResponseEntity<List<NetworkAssignDTO>> getAllNetworkAssigns(Pageable pageable) {
        log.debug("REST request to get a page of NetworkAssigns");
        Page<NetworkAssignDTO> page = networkAssignService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /network-assigns/:id} : get the "id" networkAssign.
     *
     * @param id the id of the networkAssignDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the networkAssignDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/network-assigns/{id}")
    public ResponseEntity<NetworkAssignDTO> getNetworkAssign(@PathVariable Long id) {
        log.debug("REST request to get NetworkAssign : {}", id);
        Optional<NetworkAssignDTO> networkAssignDTO = networkAssignService.findOne(id);
        return ResponseUtil.wrapOrNotFound(networkAssignDTO);
    }

    /**
     * {@code DELETE  /network-assigns/:id} : delete the "id" networkAssign.
     *
     * @param id the id of the networkAssignDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/network-assigns/{id}")
    public ResponseEntity<Void> deleteNetworkAssign(@PathVariable Long id) {
        log.debug("REST request to delete NetworkAssign : {}", id);
        networkAssignService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
