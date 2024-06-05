package com.riwi.simulacro_prueba_spring_boot.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseResp {
    private Long id;
    private String course_name;
    private String description;
    private UserResp userInstructor;
}
