package com.shsnc.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NetworkLayoutMapperTest {

    private NetworkLayoutMapper networkLayoutMapper;

    @BeforeEach
    public void setUp() {
        networkLayoutMapper = new NetworkLayoutMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(networkLayoutMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(networkLayoutMapper.fromId(null)).isNull();
    }
}
