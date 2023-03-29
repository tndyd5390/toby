package tobyspring.hellobootself;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    //    @RequestMapping(value = "/hello", method = RequestMethod.GET) -> 예전 방식 추억이다...
    @GetMapping("/hello")
    public String hello(String name) {

        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
