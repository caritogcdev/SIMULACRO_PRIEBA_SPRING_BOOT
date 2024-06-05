package com.riwi.simulacro_prueba_spring_boot.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder // Patron de diseño para creación de clases
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentReq {
    // private Long assignment_id;
    private String assignment_title;
    private String description;
    private LocalDate due_date;
    private Long lesson_id;

}
