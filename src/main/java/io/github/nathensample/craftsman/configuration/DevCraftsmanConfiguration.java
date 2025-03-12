package io.github.nathensample.craftsman.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;

@org.springframework.context.annotation.Configuration
@Profile("dev")
@ConfigurationProperties(prefix = "app")
public class DevCraftsmanConfiguration extends Configuration {

}
