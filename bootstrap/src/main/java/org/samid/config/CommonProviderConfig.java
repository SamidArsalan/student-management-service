package org.samid.config;

import org.samid.domain.common.provider.UuidProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonProviderConfig {

    @Bean
    public UuidProvider uuidProvider() { return new UuidProvider(); }

}
