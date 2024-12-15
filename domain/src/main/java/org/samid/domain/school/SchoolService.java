package org.samid.domain.school;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.samid.domain.common.enrich.CompositeEnricher;

@Slf4j
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolProvider schoolProvider;
    private final CompositeEnricher<School> enricher;

    public School findByName(String name) {
        var school = schoolProvider.findByName(name);
        if (school == null) {
            throw new SchoolNotFoundException(name);
        }
        return enricher.enrich(school);
    }

}
