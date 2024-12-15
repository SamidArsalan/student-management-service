package org.samid.infrastructure.rest.remote.school.mapper;

import org.samid.domain.school.School;
import org.samid.infrastructure.rest.SchoolResponse;
import org.springframework.stereotype.Component;

@Component
public class SchoolMapper {

    public School mapSchoolResponseToSchool(SchoolResponse schoolResponse) {
        return School.builder()
                .name(schoolResponse.name())
                .country(schoolResponse.country())
                .city(schoolResponse.city())
                .build();
    }
}
