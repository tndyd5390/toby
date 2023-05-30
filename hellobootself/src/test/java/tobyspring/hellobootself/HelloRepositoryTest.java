package tobyspring.hellobootself;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class HelloRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    HelloRepository helloRepository;

    @Test
    void findHelloFailed() {
        assertThat(helloRepository.findHello("sooyong")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("sooyong")).isEqualTo(0);

        helloRepository.increaseCount("sooyong");
        assertThat(helloRepository.countOf("sooyong")).isEqualTo(1);

        helloRepository.increaseCount("sooyong");
        assertThat(helloRepository.countOf("sooyong")).isEqualTo(2);
    }
}
