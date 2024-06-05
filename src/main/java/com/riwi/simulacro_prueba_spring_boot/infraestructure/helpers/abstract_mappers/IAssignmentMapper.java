package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.AssignmentReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.AssignmentResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Assignment;

/** Puede que no se necesiten todos los mappers pero desntro de
 * cada entidad se usará al menos una vez */
public interface IAssignmentMapper extends MapperBase<AssignmentReq, Assignment, AssignmentResp>{

}
