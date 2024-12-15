package org.samid.infrastructure.rest.remote.school;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.samid.domain.school.School;
import org.samid.domain.school.SchoolNotFoundException;
import org.samid.domain.school.SchoolProvider;
import org.samid.infrastructure.rest.SchoolResponse;
import org.samid.infrastructure.rest.remote.school.feign.delegate.FeignSchoolDelegationProvider;
import org.samid.infrastructure.rest.remote.school.mapper.SchoolMapper;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class SchoolProviderAdapter implements SchoolProvider {

//    private final FeignSchoolDelegationProvider feignSchoolDelegationProvider;
    private final SchoolMapper schoolMapper;

    @Override
    public School findByName(String name) {
        try {
//            var schoolResponse = feignSchoolDelegationProvider.searchSchool(name);
            var schoolResponse = mockSchoolResponse().stream()
                    .filter(response -> response.name().equals(name))
                    .toList();
            return schoolResponse.stream().map(schoolMapper::mapSchoolResponseToSchool)
                    .findFirst()
                    .orElse(null);
        } catch (Exception exception) {
            log.warn(exception.getMessage(), exception);
            throw new SchoolNotFoundException(name);
        }
    }

    private List<SchoolResponse> mockSchoolResponse() {
        return List.of(
          SchoolResponse.builder().name("UPS").city("Chennai").country("India").build(),
          SchoolResponse.builder().name("DPS").city("Delhi").country("India").build(),
          SchoolResponse.builder().name("Harvard").city("NY").country("USA").build(),
          SchoolResponse.builder().name("SRM").city("London").country("UK").build()
        );
    }
}
