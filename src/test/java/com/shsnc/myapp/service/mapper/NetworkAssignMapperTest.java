package com.shsnc.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NetworkAssignMapperTest {

    private NetworkAssignMapper networkAssignMapper;

    @BeforeEach
    public void setUp() {
        networkAssignMapper = new NetworkAssignMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(networkAssignMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(networkAssignMapper.fromId(null)).isNull();
    }
}
