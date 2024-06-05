package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.LessonReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.request.MessageReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.LessonResp;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.MessageResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Lesson;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Message;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.CourseRepository;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.ServiceHelper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.ICourseMapper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.ILessonMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LessonMapper implements ILessonMapper {

    @Autowired
    private final ServiceHelper helper;

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final ICourseMapper courseMapper;

    @Override
    public Lesson requestToEntity(LessonReq request) {
        return Lesson.builder()
                .lesson_title(request.getLesson_title())
                .content(request.getContent())
                .courseId(this.helper.find(request.getCourseId(), courseRepository, "course" ))
                .build();
    }

    @Override
    public LessonResp entityToResponse(Lesson entity) {
        return LessonResp.builder()
                .id(null)
                .lesson_title(entity.getLesson_title())
                .content(entity.getContent())
                .courseId(this.courseMapper.entityToResponse(entity.getCourseId()))
                .build();
    }
}
