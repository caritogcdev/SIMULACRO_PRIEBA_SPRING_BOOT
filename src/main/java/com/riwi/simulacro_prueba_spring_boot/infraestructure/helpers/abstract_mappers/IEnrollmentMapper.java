package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.EnrollmentReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.EnrollmentResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Enrollment;

/** Puede que no se necesiten todos los mappers pero desntro de
 * cada entidad se usará al menos una vez */
public interface IEnrollmentMapper extends MapperBase<EnrollmentReq, Enrollment, EnrollmentResp>{

}
