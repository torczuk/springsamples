package com.github.torczuk;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldResponseWith404WhenDriverCanNotBeFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/api/v1/driver/-1", String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody(), hasJsonPath("$.message", equalTo("Resource not Found")));
        assertThat(response.getBody(), hasJsonPath("$.path", equalTo("/api/v1/driver/-1")));
    }

    @Test
    public void shouldResponseWith403WhenDriverCanNotBeDeleted() {
        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:" + port + "/api/v1/driver",
                HttpMethod.DELETE,
                null,
                String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
        Assertions.assertThat(response.getBody()).isEqualTo("You do not have permission");
    }
}