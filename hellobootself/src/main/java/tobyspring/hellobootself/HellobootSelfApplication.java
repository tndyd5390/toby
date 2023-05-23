package tobyspring.hellobootself;

import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import tobyspring.config.MySpringBootApplication;

import javax.annotation.PostConstruct;

@MySpringBootApplication
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
