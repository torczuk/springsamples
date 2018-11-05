package com.github.torczuk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasNoJsonPath;
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
    public void shouldGetDriverById() {
        String response = restTemplate.getForObject("http://localhost:" + port + "/api/v1/driver/1", String.class);

        assertThat(response, hasJsonPath("$.first_name", equalTo("Michael")));
        assertThat(response, hasJsonPath("$.date_of_birth", equalTo("1970-05-01")));
        assertThat(response, hasNoJsonPath("$.password"));
        assertThat(response, hasNoJsonPath("$.introduce"));
    }
}