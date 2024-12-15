package org.samid.infrastructure.rest.advice;

import lombok.extern.slf4j.Slf4j;
import org.samid.domain.school.SchoolNotFoundException;
import org.samid.domain.student.StudentNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Slf4j
public class ControllerAdviceExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public ResponseError<String> onStudentNotFoundException(StudentNotFoundException exception) {
        log.warn("Student not found exception occurred!!!", exception);
        return new ResponseError<>(NOT_FOUND.value(), NOT_FOUND.getReasonPhrase(), exception.getMessage());
    }

    @ExceptionHandler(SchoolNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public ResponseError<String> onSchoolNotFoundException(SchoolNotFoundException exception) {
        log.warn("School not found exception occurred!!!", exception);
        return new ResponseError<>(NOT_FOUND.value(), NOT_FOUND.getReasonPhrase(), exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseError<String> onUnCaughtException(Exception exception) {
        log.warn("Uncaught exception occurred!!!", exception);
        return new ResponseError<>(INTERNAL_SERVER_ERROR.value(),
                INTERNAL_SERVER_ERROR.getReasonPhrase(), "Internal server error. Please Contact Support.");
    }

}
