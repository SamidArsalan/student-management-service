package org.samid.domain.student.command;

import lombok.Builder;
import org.samid.domain.common.provider.UuidProvider;
import org.samid.domain.school.School;
import org.samid.domain.student.Student;

import java.time.LocalDate;

@Builder
public record CreateStudentCommand(String name,
                                   String email,
                                   String school,
                                   LocalDate onBoardingDate) {

    public Student toStudent(UuidProvider uuidProvider) {
        return Student.builder()
                .id(uuidProvider.id())
                .name(name)
                .email(email)
                .school(School.builder().name(school).build())
                .onBoardingDate(onBoardingDate)
                .build();
    }

}
