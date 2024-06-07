package com.riwi.simulacro_prueba_spring_boot.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentUpdateReq {
    @NotBlank(message = "Title is required")
    private String assignment_title;
    private String description;
}
