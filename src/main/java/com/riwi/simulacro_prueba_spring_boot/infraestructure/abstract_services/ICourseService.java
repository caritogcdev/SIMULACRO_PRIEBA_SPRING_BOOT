package com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.CourseReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.request.CourseUpdateReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.CourseResp;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.LessonByCourseResp;

public interface ICourseService extends ServiceBase<CourseReq, CourseResp, Long>{

    CourseResp updateInfoCourse(Long id, CourseUpdateReq request);

    LessonByCourseResp getLessons(int page, int size, Long id);

}
