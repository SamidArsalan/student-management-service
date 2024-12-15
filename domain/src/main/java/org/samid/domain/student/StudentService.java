package org.samid.domain.student;

import org.samid.domain.student.command.CreateStudentCommand;

public interface StudentService {

    Student createStudent(CreateStudentCommand command);

}
