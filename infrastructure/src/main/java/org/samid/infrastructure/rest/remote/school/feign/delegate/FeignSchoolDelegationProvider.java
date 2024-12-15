package org.samid.infrastructure.rest.remote.school.feign.delegate;

import org.samid.infrastructure.rest.SchoolResponse;

//@FeignClient(name = "school-delegation-api", url = "S{school.url}", configuration = FeignSchoolDelegationConfig.class)
public interface FeignSchoolDelegationProvider {
//    @GetMapping(path = "/api/v1/schools", produces = APPLICATION_JSON_VALUE)
//    SchoolResponse searchSchool(@RequestParam(value = "schoolName") String schoolName);

    SchoolResponse searchSchool(String schoolName);
}
