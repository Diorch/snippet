package com.example.snippet.ioutility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.*;
import java.util.Set;

/**
 * @author DechuYe
 * @date 6/30/20 12:04 AM
 */
@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotNull
    @Positive
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @Max(value = 100)
    @Min(value = 0)
    private int age;

    public static void main(String[] args) throws InterruptedException {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        StudentDTO build = StudentDTO.builder().id(-1L).name("abcabc").age(-1).build();
        Set<ConstraintViolation<StudentDTO>> validate = validator.validate(build);

        validate.forEach(e -> log.error("property: {}, value: {}, msg: {}", e.getPropertyPath(), e.getInvalidValue(), e.getMessage()));
    }


}
