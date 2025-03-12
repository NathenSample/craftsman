package io.github.nathensample.craftsman.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@ConfigurationProperties(prefix = "app")
public abstract class Configuration {

    private String applicationName;

    private String serviceAccountKeyPath;

    private String spreadsheetId;

    private String gcpApiKey;

    private String spreadsheetRange;

    @Bean
    @Scope("prototype")
    public Logger produceLogger(InjectionPoint injectionPoint) {
        Class<?> classOnWired = injectionPoint.getMember().getDeclaringClass();
        return LoggerFactory.getLogger(classOnWired);
    }

    public String getSpreadsheetRange() {
        return spreadsheetRange;
    }

    public void setSpreadsheetRange(String spreadsheetRange) {
        this.spreadsheetRange = spreadsheetRange;
    }

    public String getGcpApiKey() {
        return gcpApiKey;
    }

    public void setGcpApiKey(String gcpApiKey) {
        this.gcpApiKey = gcpApiKey;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getServiceAccountKeyPath() {
        return serviceAccountKeyPath;
    }

    public void setServiceAccountKeyPath(String serviceAccountKeyPath) {
        this.serviceAccountKeyPath = serviceAccountKeyPath;
    }

    public String getSpreadsheetId() {
        return spreadsheetId;
    }

    public void setSpreadsheetId(String spreadsheetId) {
        this.spreadsheetId = spreadsheetId;
    }
}
