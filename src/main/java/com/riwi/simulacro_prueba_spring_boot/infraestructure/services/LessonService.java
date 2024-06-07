package com.riwi.simulacro_prueba_spring_boot.infraestructure.services;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.LessonReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.request.LessonUpdateReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.LessonResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Lesson;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.LessonRepository;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services.ILessonService;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.ServiceHelper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.ILessonMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService {

    @Autowired
    private final LessonRepository lessonRepository;

    @Autowired
    private final ILessonMapper lessonMapper;

    @Autowired
    private final ServiceHelper serviceHelper;


    @Override
    public LessonResp create(LessonReq request) {
        Lesson lesson = this.lessonMapper.requestToEntity(request);
        return this.lessonMapper.entityToResponse(this.lessonRepository.save(lesson));
    }

    @Override
    public LessonResp get(Long id) {
        Lesson lesson = this.serviceHelper.find(id, lessonRepository, "lesson");
        return this.lessonMapper.entityToResponse(lesson);
    }

    @Override
    public Page<LessonResp> getAll(int page, int size) {

        if (page < 0) page = 0;
        if (size <= 0) size = 5;

        return this.lessonRepository.findAll(PageRequest.of(page, size))
                .map((lesson ) -> this.lessonMapper.entityToResponse(lesson));
    }

    @Override
    public LessonResp update(Long id, LessonReq request) {

        this.serviceHelper.find(id, lessonRepository, "lesson");
        Lesson lesson = this.lessonMapper.requestToEntity(request);
        lesson.setId(id);

        return this.lessonMapper.entityToResponse(this.lessonRepository.save(lesson));
    }

    @Override
    public void delete(Long id) {
        Lesson lesson = this.serviceHelper.find(id, lessonRepository, "lesson");

        this.lessonRepository.delete(lesson);
    }

    @Override
    public LessonResp updateInfoLesson(Long id, LessonUpdateReq request) {

        Lesson lessonData = this.serviceHelper.find(id, lessonRepository, "lesson");

        Lesson lesson = this.lessonMapper.reqUpdateToEntity(request);
        lesson.setId(id);
        lesson.setCourseId(lessonData.getCourseId());

        return this.lessonMapper.entityToResponse(this.lessonRepository.save(lesson));
    }

}
