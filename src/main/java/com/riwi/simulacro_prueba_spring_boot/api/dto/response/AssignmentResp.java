package com.riwi.simulacro_prueba_spring_boot.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentResp {
    private Long id;
    private String assignment_title;
    private String description;
    private LocalDate due_date;
    private LessonResp lessonId;
}
