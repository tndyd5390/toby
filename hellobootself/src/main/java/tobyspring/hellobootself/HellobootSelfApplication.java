package tobyspring.hellobootself;

import org.springframework.boot.SpringApplication;
import tobyspring.hellobootself.config.MySpringBootApplication;

@MySpringBootApplication
public class HellobootSelfApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellobootSelfApplication.class, args);
    }
}
