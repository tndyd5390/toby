package tobyspring.hellobootself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class HellobootSelfApplication {

    private final JdbcTemplate jdbcTemplate;

    public HellobootSelfApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(HellobootSelfApplication.class, args);
    }

    @PostConstruct
    void init() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS hello (" +
                "  name VARCHAR(50), " +
                "  count INT, " +
                "  PRIMARY KEY (name) " +
                ");");
    }
}
