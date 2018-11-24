package com.torczuk.github;

import com.torczuk.github.domain.DriverRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DriverRepositoryTest {
    private static final long THREE_SECONDS = 3_000L;

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    CacheManager cacheManager;

    @Test
    @Timed(millis = THREE_SECONDS)
    public void shouldUseCache() {
        for (int i = 0; i < 20; i++) {
            driverRepository.findByNameCacheable("M Schumacher");
        }
    }

    @Test
    public void shouldGetCacheNameAfterMethodUsage() {
        driverRepository.findByNameCacheable("M Schumacher");

        Collection<String> cacheNames = cacheManager.getCacheNames();

        assertThat(cacheNames).contains("driver-names");
    }

    @Test(expected = TimeoutException.class)
    @Timed(millis = THREE_SECONDS)
    public void shouldTimeoutBecauseOfCacheEviction() {
        for (int i = 0; i < 20; i++) {
            driverRepository.findByNameCacheable("M Schumacher");
            cacheManager.getCache("driver-names").evict("M Schumacher");
        }
    }
}
