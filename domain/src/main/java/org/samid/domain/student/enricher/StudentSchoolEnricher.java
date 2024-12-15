package org.samid.domain.student.enricher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.samid.domain.common.enrich.Enricher;
import org.samid.domain.school.School;
import org.samid.domain.school.SchoolNotFoundException;
import org.samid.domain.school.SchoolService;
import org.samid.domain.student.Student;

@RequiredArgsConstructor
@Slf4j
public class StudentSchoolEnricher implements Enricher<Student> {

    private final SchoolService schoolService;

    @Override
    public Student enrich(Student student) {
        var schoolName = student.getSchool().getName();
        if (schoolName == null) {
            return student;
        }

        try {
            var school = schoolService.findByName(schoolName);
            if(school != null) {
                student.setSchool(school);
            }
        } catch (SchoolNotFoundException ex) {
            log.warn("{}. Hence School will not be stored.", ex.getMessage(), ex);
            student.setSchool(School.builder().build());
        }

        return student;
    }

}
