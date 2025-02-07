package io.github.nathensample.craftsman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync(proxyTargetClass = true)
public class Craftsman
{
    public static void main(String[] args) {
        SpringApplication.run(Craftsman.class, args);
    }
}
