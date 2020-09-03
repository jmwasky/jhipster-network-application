package com.shsnc.myapp.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.shsnc.myapp.web.rest.TestUtil;

public class NetworkAssignModifyDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(NetworkAssignModifyDTO.class);
        NetworkAssignModifyDTO networkAssignModifyDTO1 = new NetworkAssignModifyDTO();
        networkAssignModifyDTO1.setId(1L);
        NetworkAssignModifyDTO networkAssignModifyDTO2 = new NetworkAssignModifyDTO();
        assertThat(networkAssignModifyDTO1).isNotEqualTo(networkAssignModifyDTO2);
        networkAssignModifyDTO2.setId(networkAssignModifyDTO1.getId());
        assertThat(networkAssignModifyDTO1).isEqualTo(networkAssignModifyDTO2);
        networkAssignModifyDTO2.setId(2L);
        assertThat(networkAssignModifyDTO1).isNotEqualTo(networkAssignModifyDTO2);
        networkAssignModifyDTO1.setId(null);
        assertThat(networkAssignModifyDTO1).isNotEqualTo(networkAssignModifyDTO2);
    }
}
