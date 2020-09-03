package com.shsnc.myapp.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.shsnc.myapp.web.rest.TestUtil;

public class NetworkAssignDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(NetworkAssignDTO.class);
        NetworkAssignDTO networkAssignDTO1 = new NetworkAssignDTO();
        networkAssignDTO1.setId(1L);
        NetworkAssignDTO networkAssignDTO2 = new NetworkAssignDTO();
        assertThat(networkAssignDTO1).isNotEqualTo(networkAssignDTO2);
        networkAssignDTO2.setId(networkAssignDTO1.getId());
        assertThat(networkAssignDTO1).isEqualTo(networkAssignDTO2);
        networkAssignDTO2.setId(2L);
        assertThat(networkAssignDTO1).isNotEqualTo(networkAssignDTO2);
        networkAssignDTO1.setId(null);
        assertThat(networkAssignDTO1).isNotEqualTo(networkAssignDTO2);
    }
}
