package com.riwi.simulacro_prueba_spring_boot.api.dto.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CourseResp {
    private Long id;
    private String course_name;
    private String description;
    private UserResp userInstructor;
}
