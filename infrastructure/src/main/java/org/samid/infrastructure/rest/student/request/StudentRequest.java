package org.samid.infrastructure.rest.student.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.samid.domain.student.command.CreateStudentCommand;

import java.time.LocalDate;

@Builder
public record StudentRequest(
        @Valid
        @Size(max = 100, message = "Student's name cannot exceed 100 characters")
        @NotBlank(message = "Name is required and cannot be empty")
        String name,
        String email,
        String school,
        LocalDate onBoardingDate

) {

    public CreateStudentCommand toCommand() {
        return CreateStudentCommand.builder()
                .name(name)
                .email(email)
                .school(school)
                .onBoardingDate(onBoardingDate)
                .build();
    }

}
