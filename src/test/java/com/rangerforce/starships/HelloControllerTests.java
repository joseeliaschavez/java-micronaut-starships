package com.rangerforce.starships;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class HelloControllerTests {
    @Inject
    @Client("/")
    HttpClient client;

    public void testIndex() {
        // Arrange
        var request = HttpRequest.GET("/hello").accept(MediaType.TEXT_PLAIN);

        // Act
        var body = client.toBlocking().retrieve(request);

        // Assert
        assertNotNull(body);
        assertEquals("Hello World", body);
    }
}
