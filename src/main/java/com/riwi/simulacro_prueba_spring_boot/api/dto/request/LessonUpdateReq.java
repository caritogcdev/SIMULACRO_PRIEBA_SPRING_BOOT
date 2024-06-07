package com.riwi.simulacro_prueba_spring_boot.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/** Request para actualizar lecciones sin el curso */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonUpdateReq {
    @NotBlank(message = "Title is required")
    private String lesson_title;
    private String content;
}
