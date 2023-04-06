package tobyspring.hellobootself;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloApiTest {
    @Test
    void helloApi() {
        //given
        TestRestTemplate rest = new TestRestTemplate();
        String parameter = "Spring";

        //when
        ResponseEntity<String> response = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class, parameter);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        assertThat(response.getBody()).isEqualTo("*Hello " + parameter + "*");
    }

    @Test
    void failHelloApi() {
        //given
        TestRestTemplate rest = new TestRestTemplate();
        String parameter = "Spring";

        //when
        ResponseEntity<String> response = rest.getForEntity("http://localhost:8080/hello?name=", String.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
