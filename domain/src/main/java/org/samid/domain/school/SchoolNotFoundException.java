package org.samid.domain.school;

import static java.lang.String.format;

public class SchoolNotFoundException extends RuntimeException {

    public SchoolNotFoundException(String name) {
        super(format("School not found - %S", name));
    }
}
