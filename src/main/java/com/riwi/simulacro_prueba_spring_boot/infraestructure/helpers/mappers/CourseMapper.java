package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.CourseReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.CourseResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Course;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.ICourseMapper;

public class CourseMapper implements ICourseMapper {
    @Override
    public Course requestToEntity(CourseReq request) {
        return Course.builder()
                .course_name(request.getCourse_name())
                .description(request.getDescription())
                .userInstructor(null)
                .build();
    }

    @Override
    public CourseResp entityToResponse(Course entity) {
        return CourseResp.builder()
                .id(entity.getId())
                .course_name(entity.getCourse_name())
                .description(entity.getDescription())
                .userInstructor(null)
                .build();
    }
}
