package org.samid.domain.student;

import lombok.RequiredArgsConstructor;
import org.samid.domain.common.enrich.CompositeEnricher;
import org.samid.domain.common.provider.UuidProvider;
import org.samid.domain.student.command.CreateStudentCommand;

@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final UuidProvider uuidProvider;
    private final CompositeEnricher<Student> writeEnricher;
    private final StudentRepository studentRepository;

    public Student createStudent(CreateStudentCommand command) {
        var student = command.toStudent(uuidProvider);
        student = writeEnricher.enrich(student);
        student = studentRepository.save(student);
        return student;
    }

}
