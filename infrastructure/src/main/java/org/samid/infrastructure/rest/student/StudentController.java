package org.samid.infrastructure.rest.student;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.samid.domain.student.StudentService;
import org.samid.infrastructure.rest.student.request.StudentRequest;
import org.samid.infrastructure.rest.student.response.StudentSuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

@Slf4j
@AllArgsConstructor
@RestController
public class StudentController implements StudentApi {

    private final StudentService studentService;


    @Override
    public ResponseEntity<StudentSuccessResponse> createStudent(StudentRequest studentRequest) {
        log.info("Creating student data based on request");
        val command = studentRequest.toCommand();
        val student = studentService.createStudent(command);
        return status(CREATED).body(new StudentSuccessResponse(student.getId()));
    }


}
