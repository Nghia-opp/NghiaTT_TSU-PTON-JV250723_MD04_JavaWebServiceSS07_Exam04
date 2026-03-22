package com.exam04.controler;

import com.exam04.dto.StudentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @PostMapping
    public ResponseEntity<?> createStudent(
            @Valid @RequestBody StudentDTO studentDTO,
            BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage) // Chỉ lấy câu thông báo
                    .collect(Collectors.toList());


            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.ok("Thêm sinh viên thành công!");
    }
}
