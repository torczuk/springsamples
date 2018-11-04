package com.torczuk.github;

import com.torczuk.github.domain.DriverRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DriverRepositoryTest {
    private static final long THREE_SECONDS = 3_000L;

    @Autowired
    private DriverRepository driverRepository;

    @Test
    @Timed(millis = THREE_SECONDS)
    public void shouldCacheMethod() {
        for (int i = 0; i < 20; i++) {
            driverRepository.findByNameCachable("M Schumacher");
        }
    }

}
