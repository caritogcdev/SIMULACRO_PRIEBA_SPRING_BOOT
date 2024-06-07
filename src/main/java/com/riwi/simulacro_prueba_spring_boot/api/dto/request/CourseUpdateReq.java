package com.riwi.simulacro_prueba_spring_boot.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/** Request para actualizar cursos sin el instructor */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseUpdateReq {
    @NotBlank(message = "The name is required")
    private String course_name;
    private String description;

}
