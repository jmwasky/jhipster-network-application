package com.shsnc.myapp.repository;

import com.shsnc.myapp.domain.NetworkAssignModify;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the NetworkAssignModify entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NetworkAssignModifyRepository extends JpaRepository<NetworkAssignModify, Long> {
}
