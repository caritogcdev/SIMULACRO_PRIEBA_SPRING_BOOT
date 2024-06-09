package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.EnrollmentReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.EnrollmentResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Enrollment;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.CourseRepository;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.UserRepository;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.ServiceHelper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.ICourseMapper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.IEnrollmentMapper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.IUserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnrollmentMapper implements IEnrollmentMapper {

    @Autowired
    private final ServiceHelper serviceHelper;

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final ICourseMapper courseMapper;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final IUserMapper userMapper;

    @Override
    public Enrollment requestToEntity(EnrollmentReq request) {
        return Enrollment.builder()
                .courseId(this.serviceHelper.find(request.getCourseId(), courseRepository, "course"))
                .userId(this.serviceHelper.find(request.getUserId(), userRepository, "user"))
                .build();
    }

    @Override
    public EnrollmentResp entityToResponse(Enrollment entity) {
        return EnrollmentResp.builder()
                .id(entity.getId())
                .userId(this.userMapper.entityToResponse(entity.getUserId()))
                .courseId(this.courseMapper.entityToResponse(entity.getCourseId()))
                .enrollment_date(entity.getEnrollment_date())
                .build();
    }
}
