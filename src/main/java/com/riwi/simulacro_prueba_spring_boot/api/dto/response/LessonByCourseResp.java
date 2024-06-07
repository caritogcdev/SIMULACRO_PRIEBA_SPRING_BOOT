package com.riwi.simulacro_prueba_spring_boot.api.dto.response;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Page;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LessonByCourseResp extends CourseResp {
    private Page<LessonResp> lessons;
}
