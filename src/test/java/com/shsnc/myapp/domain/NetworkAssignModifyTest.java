package com.shsnc.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.shsnc.myapp.web.rest.TestUtil;

public class NetworkAssignModifyTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(NetworkAssignModify.class);
        NetworkAssignModify networkAssignModify1 = new NetworkAssignModify();
        networkAssignModify1.setId(1L);
        NetworkAssignModify networkAssignModify2 = new NetworkAssignModify();
        networkAssignModify2.setId(networkAssignModify1.getId());
        assertThat(networkAssignModify1).isEqualTo(networkAssignModify2);
        networkAssignModify2.setId(2L);
        assertThat(networkAssignModify1).isNotEqualTo(networkAssignModify2);
        networkAssignModify1.setId(null);
        assertThat(networkAssignModify1).isNotEqualTo(networkAssignModify2);
    }
}
