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
public class EnrollmentResp {
    private Long id;
    private LocalDate enrollment_date;
    private UserResp userId;
    private CourseResp courseId;
}
