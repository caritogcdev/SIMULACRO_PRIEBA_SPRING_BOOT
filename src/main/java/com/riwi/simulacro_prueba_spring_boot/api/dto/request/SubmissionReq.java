package com.riwi.simulacro_prueba_spring_boot.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionReq {
    @NotBlank(message = "Content is required")
    private String content;
    @NotBlank(message = "User is required")
    private String userId;
    @NotBlank(message = "Assignment is required")
    private Long assignmentId;
}
