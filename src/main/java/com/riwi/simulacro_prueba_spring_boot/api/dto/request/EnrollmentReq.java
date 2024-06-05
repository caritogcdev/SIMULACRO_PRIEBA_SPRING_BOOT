package com.riwi.simulacro_prueba_spring_boot.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentReq {
    @NotBlank(message = "User is required")
    private String userId;
    @NotNull(message = "Course is required")
    private Long courseId;
}
