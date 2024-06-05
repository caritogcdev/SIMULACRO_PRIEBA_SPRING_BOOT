package com.riwi.simulacro_prueba_spring_boot.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionResp {
    private Long id;
    private String content;
    private LocalDateTime submission_date;
    private BigDecimal grade;
    private UserResp userId;
    private AssignmentResp assignmentId;
}
