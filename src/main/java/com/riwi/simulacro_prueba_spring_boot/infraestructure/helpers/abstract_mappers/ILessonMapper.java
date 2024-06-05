package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.LessonReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.LessonResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Lesson;

/** Puede que no se necesiten todos los mappers pero desntro de
 * cada entidad se usará al menos una vez */
public interface ILessonMapper extends MapperBase<LessonReq, Lesson, LessonResp>{

}
