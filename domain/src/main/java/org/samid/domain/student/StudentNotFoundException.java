package org.samid.domain.student;

import static java.lang.String.format;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String id) { super(format("Student not found for the given id %s", id)); }
}
