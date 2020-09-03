package com.shsnc.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NetworkAssignModifyMapperTest {

    private NetworkAssignModifyMapper networkAssignModifyMapper;

    @BeforeEach
    public void setUp() {
        networkAssignModifyMapper = new NetworkAssignModifyMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(networkAssignModifyMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(networkAssignModifyMapper.fromId(null)).isNull();
    }
}
