package com.example.springbootac;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootAcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootAcApplication.class, args);
    }

    @Bean
    ApplicationRunner run(ConditionEvaluationReport report) {
        return args -> {
            System.out.println(report.getConditionAndOutcomesBySource().entrySet().stream()
                    .filter(co -> co.getValue().isFullMatch())
                    .map(co -> {
                        System.out.println(co.getKey());
                        co.getValue().forEach(c -> {
                            System.out.println("\t" + c.getOutcome());
                        });
                        System.out.println();
                        return co;
                    }).count());
        };
    }

}
