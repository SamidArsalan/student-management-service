package org.samid.domain.school.enricher;

import org.samid.domain.common.enrich.Enricher;
import org.samid.domain.school.School;

public class SchoolEnricher implements Enricher<School> {

    @Override
    public School enrich(School school) {
        return school;
    }

}
