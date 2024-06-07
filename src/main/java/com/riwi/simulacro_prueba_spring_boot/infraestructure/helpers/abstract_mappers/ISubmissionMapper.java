package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.SubmissionReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.SubmissionResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Submission;

/** Puede que no se necesiten todos los mappers pero dentro de
 * cada entidad se usará al menos una vez */
public interface ISubmissionMapper extends MapperBase<SubmissionReq, Submission, SubmissionResp>{

}
