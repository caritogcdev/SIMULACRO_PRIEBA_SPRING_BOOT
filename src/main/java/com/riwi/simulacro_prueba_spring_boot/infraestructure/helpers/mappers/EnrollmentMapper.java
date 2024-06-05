package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.EnrollmentReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.EnrollmentResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Enrollment;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.IEnrollmentMapper;

public class EnrollmentMapper implements IEnrollmentMapper {
    @Override
    public Enrollment requestToEntity(EnrollmentReq request) {
        return Enrollment.builder()
                .courseId(null)
                .userId(null)
                .build();
    }

    @Override
    public EnrollmentResp entityToResponse(Enrollment entity) {
        return EnrollmentResp.builder()
                .id(entity.getId())
                .userId(null)
                .courseId(null)
                .enrollment_date(entity.getEnrollment_date())
                .build();
    }
}
