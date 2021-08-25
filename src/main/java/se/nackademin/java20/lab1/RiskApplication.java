package se.nackademin.java20.lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class RiskApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiskApplication.class, args);
    }

}
