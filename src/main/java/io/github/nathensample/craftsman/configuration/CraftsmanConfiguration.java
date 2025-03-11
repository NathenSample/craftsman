package io.github.nathensample.craftsman.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
@Profile("live")
public class CraftsmanConfiguration {
    @Value("${applicationName}")
    private String APPLICATION_NAME;

    @Value("${serviceAccountKeyPath}")
    private String SERVICE_ACCOUNT_KEY_PATH;

    @Value("${spreadsheetID}")
    private String SPREADSHEET_ID;

    @Bean
    @Scope("prototype")
    public Logger produceLogger(InjectionPoint injectionPoint) {
        Class<?> classOnWired = injectionPoint.getMember().getDeclaringClass();
        return LoggerFactory.getLogger(classOnWired);
    }

    public String getAPPLICATION_NAME() {
        return APPLICATION_NAME;
    }

    public String getSERVICE_ACCOUNT_KEY_PATH() {
        return SERVICE_ACCOUNT_KEY_PATH;
    }

    public String getSPREADSHEET_ID() {
        return SPREADSHEET_ID;
    }
}
