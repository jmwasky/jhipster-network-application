package com.shsnc.myapp.web.rest;

import com.shsnc.myapp.service.NetworkLayoutService;
import com.shsnc.myapp.web.rest.errors.BadRequestAlertException;
import com.shsnc.myapp.service.dto.NetworkLayoutDTO;

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
 * REST controller for managing {@link com.shsnc.myapp.domain.NetworkLayout}.
 */
@RestController
@RequestMapping("/api")
public class NetworkLayoutResource {

    private final Logger log = LoggerFactory.getLogger(NetworkLayoutResource.class);

    private static final String ENTITY_NAME = "jhipsterNetworkApplicationNetworkLayout";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NetworkLayoutService networkLayoutService;

    public NetworkLayoutResource(NetworkLayoutService networkLayoutService) {
        this.networkLayoutService = networkLayoutService;
    }

    /**
     * {@code POST  /network-layouts} : Create a new networkLayout.
     *
     * @param networkLayoutDTO the networkLayoutDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new networkLayoutDTO, or with status {@code 400 (Bad Request)} if the networkLayout has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/network-layouts")
    public ResponseEntity<NetworkLayoutDTO> createNetworkLayout(@Valid @RequestBody NetworkLayoutDTO networkLayoutDTO) throws URISyntaxException {
        log.debug("REST request to save NetworkLayout : {}", networkLayoutDTO);
        if (networkLayoutDTO.getId() != null) {
            throw new BadRequestAlertException("A new networkLayout cannot already have an ID", ENTITY_NAME, "idexists");
        }
        NetworkLayoutDTO result = networkLayoutService.save(networkLayoutDTO);
        return ResponseEntity.created(new URI("/api/network-layouts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /network-layouts} : Updates an existing networkLayout.
     *
     * @param networkLayoutDTO the networkLayoutDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated networkLayoutDTO,
     * or with status {@code 400 (Bad Request)} if the networkLayoutDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the networkLayoutDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/network-layouts")
    public ResponseEntity<NetworkLayoutDTO> updateNetworkLayout(@Valid @RequestBody NetworkLayoutDTO networkLayoutDTO) throws URISyntaxException {
        log.debug("REST request to update NetworkLayout : {}", networkLayoutDTO);
        if (networkLayoutDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        NetworkLayoutDTO result = networkLayoutService.save(networkLayoutDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, networkLayoutDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /network-layouts} : get all the networkLayouts.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of networkLayouts in body.
     */
    @GetMapping("/network-layouts")
    public ResponseEntity<List<NetworkLayoutDTO>> getAllNetworkLayouts(Pageable pageable) {
        log.debug("REST request to get a page of NetworkLayouts");
        Page<NetworkLayoutDTO> page = networkLayoutService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /network-layouts/:id} : get the "id" networkLayout.
     *
     * @param id the id of the networkLayoutDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the networkLayoutDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/network-layouts/{id}")
    public ResponseEntity<NetworkLayoutDTO> getNetworkLayout(@PathVariable Long id) {
        log.debug("REST request to get NetworkLayout : {}", id);
        Optional<NetworkLayoutDTO> networkLayoutDTO = networkLayoutService.findOne(id);
        return ResponseUtil.wrapOrNotFound(networkLayoutDTO);
    }

    /**
     * {@code DELETE  /network-layouts/:id} : delete the "id" networkLayout.
     *
     * @param id the id of the networkLayoutDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/network-layouts/{id}")
    public ResponseEntity<Void> deleteNetworkLayout(@PathVariable Long id) {
        log.debug("REST request to delete NetworkLayout : {}", id);
        networkLayoutService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
