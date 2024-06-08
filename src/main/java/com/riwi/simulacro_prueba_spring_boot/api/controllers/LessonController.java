package com.riwi.simulacro_prueba_spring_boot.api.controllers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.LessonReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.request.LessonUpdateReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.LessonResp;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services.ILessonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/lessons")
@AllArgsConstructor
@Tag(name = "Lessons")
public class LessonController implements BaseController<LessonReq, LessonResp, Long> {

    @Autowired
    private final ILessonService lessonService;

    @PostMapping
    @Override
    public ResponseEntity<LessonResp> create(
            @Validated @RequestBody LessonReq request) {
        return ResponseEntity.ok(this.lessonService.create(request));
    }

    @GetMapping(path = "/{lessonId}")
    @Override
    public ResponseEntity<LessonResp> get(
            @PathVariable Long lessonId) {
        return ResponseEntity.ok(this.lessonService.get(lessonId));
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<LessonResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(this.lessonService.getAll(page - 1, size));
    }

    @PutMapping(path = "/{lessonId}")
    @Override
    public ResponseEntity<LessonResp> update(
            @Validated @RequestBody LessonReq request,
            @PathVariable Long lessonId) {

        return ResponseEntity.ok(this.lessonService.update(lessonId, request));
    }

    @DeleteMapping(path = "/{lessonId}")
    @Override
    public ResponseEntity<Void> delete(
            @PathVariable Long lessonId) {

        this.lessonService.delete(lessonId);

        return ResponseEntity.noContent().build();
    }

    //Actualizar información únicamente de lesson sin curso

    @PutMapping(path = "/{lessonId}/updatedInfo")
    public ResponseEntity<LessonResp> updateInfoLesson(
            @Validated @RequestBody LessonUpdateReq request,
            @PathVariable Long lessonId) {
        return ResponseEntity.ok(this.lessonService.updateInfoLesson(lessonId, request));
    }
}
