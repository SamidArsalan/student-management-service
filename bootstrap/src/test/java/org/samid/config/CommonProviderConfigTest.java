package org.samid.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.samid.AutoConfigureTest;
import org.samid.domain.common.provider.UuidProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.samid.config.BeanAssertions.assertMandatoryBeans;

@AutoConfigureTest
class CommonProviderConfigTest {

    private static final List<Class<?>> MANDATORY_PROVIDER_BEANS = List.of(
            UuidProvider.class
    );

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    @DisplayName("should load all common provider beans")
    void shouldLoadAllCommonProviderBeans() {
        assertMandatoryBeans(MANDATORY_PROVIDER_BEANS, applicationContext);
    }

}
