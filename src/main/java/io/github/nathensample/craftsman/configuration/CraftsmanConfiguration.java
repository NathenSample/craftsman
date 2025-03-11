package io.github.nathensample.craftsman.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
@Profile("live")
public class CraftsmanConfiguration {

    @Bean
    public String applicationName() {
        return "Craftsman";
    }

    @Bean
    public String spreadsheetID() {
        return "ID";//TODO: real IDs
    }

    @Bean
    public String serviceAccountKeyPath() {
        return "/etc/secrets/live-service-account.json";
    }

    @Bean
    @Scope("prototype")
    public Logger produceLogger(InjectionPoint injectionPoint) {
        Class<?> classOnWired = injectionPoint.getMember().getDeclaringClass();
        return LoggerFactory.getLogger(classOnWired);
    }
}
