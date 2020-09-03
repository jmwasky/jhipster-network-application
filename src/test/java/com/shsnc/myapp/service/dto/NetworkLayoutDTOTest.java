package com.shsnc.myapp.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.shsnc.myapp.web.rest.TestUtil;

public class NetworkLayoutDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(NetworkLayoutDTO.class);
        NetworkLayoutDTO networkLayoutDTO1 = new NetworkLayoutDTO();
        networkLayoutDTO1.setId(1L);
        NetworkLayoutDTO networkLayoutDTO2 = new NetworkLayoutDTO();
        assertThat(networkLayoutDTO1).isNotEqualTo(networkLayoutDTO2);
        networkLayoutDTO2.setId(networkLayoutDTO1.getId());
        assertThat(networkLayoutDTO1).isEqualTo(networkLayoutDTO2);
        networkLayoutDTO2.setId(2L);
        assertThat(networkLayoutDTO1).isNotEqualTo(networkLayoutDTO2);
        networkLayoutDTO1.setId(null);
        assertThat(networkLayoutDTO1).isNotEqualTo(networkLayoutDTO2);
    }
}
