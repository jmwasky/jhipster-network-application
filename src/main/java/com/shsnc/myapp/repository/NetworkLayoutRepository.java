package com.shsnc.myapp.repository;

import com.shsnc.myapp.domain.NetworkLayout;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the NetworkLayout entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NetworkLayoutRepository extends JpaRepository<NetworkLayout, Long> {
}
