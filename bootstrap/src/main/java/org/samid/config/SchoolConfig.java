package org.samid.config;

import org.samid.domain.common.enrich.CompositeEnricher;
import org.samid.domain.school.School;
import org.samid.domain.school.SchoolProvider;
import org.samid.domain.school.SchoolService;
import org.samid.infrastructure.rest.remote.school.SchoolProviderAdapter;
import org.samid.infrastructure.rest.remote.school.mapper.SchoolMapper;
import org.springframework.context.annotation.Bean;

public class SchoolConfig {

    @Bean
    public SchoolService schoolService(SchoolProvider schoolProvider,
                                       CompositeEnricher<School> compositeEnricher) {
        return new SchoolService(schoolProvider, compositeEnricher);
    }

    @Bean
    public SchoolProvider schoolProvider(SchoolMapper schoolMapper) {
        return new SchoolProviderAdapter(schoolMapper);
    }

}
