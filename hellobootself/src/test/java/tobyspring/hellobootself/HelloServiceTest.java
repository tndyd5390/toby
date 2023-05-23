package tobyspring.hellobootself;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {

    private static HelloRepository helloRepositoryStub = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    };

    @Test
    void simpleHelloService() {
        //given
        SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub);

        //when
        String ret = helloService.sayHello("Test");

        //then
        assertThat(ret).isEqualTo("Hello Test");
    }

    @Test
    void helloDecorator() {
        //given
        HelloDecorator decorator = new HelloDecorator(name -> name);

        //when
        String ret = decorator.sayHello("Test");

        //then
        assertThat(ret).isEqualTo("*Test*");
    }
}
