package org.samid.infrastructure.repository.jpa.mapper;

import org.samid.domain.school.School;
import org.samid.domain.student.Student;
import org.samid.infrastructure.repository.Mapper;
import org.samid.infrastructure.repository.jpa.StudentEntity;

public class StudentMapper implements Mapper<Student, StudentEntity> {

    @Override
    public StudentEntity toEntity(Student student) {
        return StudentEntity.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .onBoardingDate(student.getOnBoardingDate())
                .schoolName(student.getSchool().getName())
                .build();
    }

    @Override
    public Student toDomain(StudentEntity entity) {
        return Student.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .onBoardingDate(entity.getOnBoardingDate())
                .school(School.builder().name(entity.getSchoolName()).build())
                .build();
    }

}
