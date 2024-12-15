package org.samid.infrastructure.rest.remote;

import lombok.extern.slf4j.Slf4j;
import org.samid.domain.school.School;
import org.samid.domain.school.SchoolNotFoundException;
import org.samid.domain.school.SchoolProvider;

@Slf4j
public class SchoolProviderAdapter implements SchoolProvider {

    private final FeignSchoolDelegationProvider feignSchoolDelegationProvider;

    @Override
    public School findByName(String name) {
        try {
            return feignSchoolDelegationProvider.searchSchool(name);
        } catch (Exception exception) {
            log.warn(exception.getMessage(), exception);
            throw new SchoolNotFoundException(name);
        }
    }
}
