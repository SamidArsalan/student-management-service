package org.samid.domain.student;

import lombok.Builder;
import lombok.Data;
import org.samid.domain.school.School;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class Student {

    private UUID id;

    private String name;

    private String email;

    private School school;

    private LocalDate onBoardingDate;
}
