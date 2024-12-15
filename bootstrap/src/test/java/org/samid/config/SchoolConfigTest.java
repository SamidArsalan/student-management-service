package org.samid.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.samid.MainApplication;
import org.samid.domain.school.SchoolProvider;
import org.samid.domain.school.SchoolService;
import org.samid.domain.school.enricher.SchoolEnricher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.samid.config.BeanAssertions.assertMandatoryBeans;

@SpringBootTest(classes = {MainApplication.class})
@ActiveProfiles("test")
class SchoolConfigTest {

    private static final List<Class<?>> MANDATORY_SCHOOL_BEANS = List.of(
            SchoolService.class, SchoolProvider.class, SchoolEnricher.class
    );

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    @DisplayName("should load all school related beans")
    void shouldLoadAllSchoolBeans() {
        assertMandatoryBeans(MANDATORY_SCHOOL_BEANS, applicationContext);
    }

}
