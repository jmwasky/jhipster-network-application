package com.shsnc.myapp.repository;

import com.shsnc.myapp.domain.NetworkAssign;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the NetworkAssign entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NetworkAssignRepository extends JpaRepository<NetworkAssign, Long> {
}
