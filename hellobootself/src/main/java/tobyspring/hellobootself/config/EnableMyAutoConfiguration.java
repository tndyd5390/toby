package tobyspring.hellobootself.config;

import org.springframework.context.annotation.Import;
import tobyspring.hellobootself.config.autoconfig.DispatcherServletConfig;
import tobyspring.hellobootself.config.autoconfig.TomcatWebServerConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({TomcatWebServerConfiguration.class, DispatcherServletConfig.class})
public @interface EnableMyAutoConfiguration {
}
