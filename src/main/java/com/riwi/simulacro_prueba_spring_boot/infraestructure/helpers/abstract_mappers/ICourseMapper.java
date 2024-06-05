package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.CourseReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.CourseResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Course;

/** Puede que no se necesiten todos los mappers pero desntro de
 * cada entidad se usará al menos una vez */
public interface ICourseMapper extends MapperBase<CourseReq, Course, CourseResp>{

}
