package com.shsnc.myapp.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.shsnc.myapp.web.rest.TestUtil;

public class NetworkLayoutTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(NetworkLayout.class);
        NetworkLayout networkLayout1 = new NetworkLayout();
        networkLayout1.setId(1L);
        NetworkLayout networkLayout2 = new NetworkLayout();
        networkLayout2.setId(networkLayout1.getId());
        assertThat(networkLayout1).isEqualTo(networkLayout2);
        networkLayout2.setId(2L);
        assertThat(networkLayout1).isNotEqualTo(networkLayout2);
        networkLayout1.setId(null);
        assertThat(networkLayout1).isNotEqualTo(networkLayout2);
    }
}
