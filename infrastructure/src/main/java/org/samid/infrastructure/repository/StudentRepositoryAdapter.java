package org.samid.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.samid.domain.student.Student;
import org.samid.domain.student.StudentRepository;
import org.samid.infrastructure.repository.jpa.JpaStudentRepository;
import org.samid.infrastructure.repository.jpa.StudentEntity;

@RequiredArgsConstructor
public class StudentRepositoryAdapter implements StudentRepository {

    private final JpaStudentRepository jpaStudentRepository;

    private final Mapper<Student, StudentEntity> studentMapper;

    @Override
    public Student save(Student student) {
        return studentMapper.toDomain(jpaStudentRepository.save(studentMapper.toEntity(student)));
    }

}
