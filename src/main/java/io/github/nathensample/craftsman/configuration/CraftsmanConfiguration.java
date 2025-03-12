package io.github.nathensample.craftsman.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;

@org.springframework.context.annotation.Configuration
@Profile("live")
@ConfigurationProperties(prefix = "app")
public class CraftsmanConfiguration extends Configuration {

}
