package org.samid.infrastructure.repository.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "STUDENT")
public class StudentEntity {

    @Id
    @Column(name = "STUDENT_ID")
    private UUID id;

    @Column(name = "STUDENT_NAME")
    private String name;

    @Column(name = "STUDENT_EMAIL")
    private String email;

    @Column(name = "SCHOOL")
    private String schoolName;

    @Column(name = "ON_BOARDING_DATE")
    private LocalDate onBoardingDate;

}
