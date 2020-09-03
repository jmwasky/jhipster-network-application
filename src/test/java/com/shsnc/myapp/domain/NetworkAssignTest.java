package com.shsnc.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.shsnc.myapp.web.rest.TestUtil;

public class NetworkAssignTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(NetworkAssign.class);
        NetworkAssign networkAssign1 = new NetworkAssign();
        networkAssign1.setId(1L);
        NetworkAssign networkAssign2 = new NetworkAssign();
        networkAssign2.setId(networkAssign1.getId());
        assertThat(networkAssign1).isEqualTo(networkAssign2);
        networkAssign2.setId(2L);
        assertThat(networkAssign1).isNotEqualTo(networkAssign2);
        networkAssign1.setId(null);
        assertThat(networkAssign1).isNotEqualTo(networkAssign2);
    }
}
