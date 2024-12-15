package org.samid.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.samid.AutoConfigureTest;
import org.samid.domain.student.StudentRepository;
import org.samid.domain.student.StudentService;
import org.samid.domain.student.enricher.StudentSchoolEnricher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.samid.config.BeanAssertions.assertMandatoryBeans;

@AutoConfigureTest
class StudentConfigTest {

    private static final List<Class<?>> MANDATORY_STUDENT_BEANS = List.of(
            StudentService.class, StudentRepository.class, StudentSchoolEnricher.class
    );

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    @DisplayName("should load all student related beans")
    void shouldLoadAllCommonProviderBeans() {
        assertMandatoryBeans(MANDATORY_STUDENT_BEANS, applicationContext);
    }

}