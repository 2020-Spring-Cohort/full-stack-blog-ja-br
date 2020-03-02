package org.wcci.blog.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.wcci.blog.models.Genre;
import org.wcci.blog.storage.GenreStorage;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private GenreStorage genreStorage;
    private Genre testGenre;

    @BeforeEach
    public void testClassSetup() {
        testGenre = new Genre("HTTP Request Test Campus");
        genreStorage.store(testGenre);
    }

    @Test
    public void campusesEndPointReturnsOK() {
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/genres", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
