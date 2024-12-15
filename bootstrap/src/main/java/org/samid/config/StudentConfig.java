package org.samid.config;

import org.samid.domain.common.enrich.CompositeEnricher;
import org.samid.domain.common.provider.UuidProvider;
import org.samid.domain.student.Student;
import org.samid.domain.student.StudentService;
import org.samid.domain.student.StudentServiceImpl;
import org.samid.domain.student.enricher.StudentSchoolEnricher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean("studentWriterEnricher")
    public CompositeEnricher<Student> studentWriteEnricher(StudentSchoolEnricher studentSchoolEnricher) {
        return new CompositeEnricher<>(List.of(studentSchoolEnricher));
    }

    @Bean
    public StudentService studentService(UuidProvider uuidProvider,
                                         @Autowired @Qualifier("studentWriterEnricher")CompositeEnricher<Student> studentWriteEnricher) {
        return new StudentServiceImpl(uuidProvider, studentWriteEnricher);
    }

}
