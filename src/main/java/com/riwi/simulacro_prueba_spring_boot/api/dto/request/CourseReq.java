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
public class CourseReq {
   @NotBlank(message = "Name is required")
   private String course_name;
   private String description;
   @NotBlank(message = "Instructor is required")
   private String userInstructor;

}
