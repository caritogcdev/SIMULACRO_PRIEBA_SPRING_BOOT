package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.CourseReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.request.CourseUpdateReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.CourseResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Course;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.User;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.UserRepository;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.ServiceHelper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.ICourseMapper;
import com.riwi.simulacro_prueba_spring_boot.utils.enums.Role;
import com.riwi.simulacro_prueba_spring_boot.utils.exceptions.NotAuthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseMapper implements ICourseMapper {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private final ServiceHelper serviceHelper;

    @Override
    public Course requestToEntity(CourseReq request) {

        // Nos traemos el id del instructor
        User userInstructor = this.serviceHelper.find(request.getUserInstructor(), userRepository, "User Instructor");

        // Validando que un estudiante no pueda ser un instructor porque no tiene rol de INSTRUCTOR sino de STUDENT
        if (userInstructor.getRole() == Role.STUDENT) {
            throw new NotAuthorizedException("A student can't be a course instructor");
        }

        return Course.builder()
                .course_name(request.getCourse_name())
                .description(request.getDescription())
                .userInstructor(userInstructor)
                .build();
    }

    @Override
    public CourseResp entityToResponse(Course entity) {
        return CourseResp.builder()
                .id(entity.getId())
                .course_name(entity.getCourse_name())
                .description(entity.getDescription())
                .userInstructor(this.userMapper.entityToResponse(entity.getUserInstructor()))
                .build();
    }

    @Override
    public Course reqUpdateToEntity(CourseUpdateReq request) {
        return Course.builder()
                .course_name(request.getCourse_name())
                .description(request.getDescription())
                .build();
    }
}
