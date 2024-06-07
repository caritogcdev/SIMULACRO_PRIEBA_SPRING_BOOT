package com.riwi.simulacro_prueba_spring_boot.api.controllers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.CourseReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.request.CourseUpdateReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.CourseResp;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.LessonByCourseResp;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services.ICourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/courses")
@AllArgsConstructor
@Tag(name = "Courses")
public class CourseController implements ControllerBase<CourseReq, CourseResp, Long>{

    @Autowired
    private final ICourseService courseService;

    @PostMapping
    @Override
    public ResponseEntity<CourseResp> create(
            @Validated @RequestBody CourseReq request) {
        return ResponseEntity.ok(this.courseService.create(request));
    }

    @GetMapping(path = "/{courseId}")
    @Override
    public ResponseEntity<CourseResp> get(
            @PathVariable Long courseId) {
        return ResponseEntity.ok(this.courseService.get(courseId));
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<CourseResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(this.courseService.getAll(page - 1, size));
    }

    @PutMapping(path = "/{courseId}")
    @Override
    public ResponseEntity<CourseResp> update(
            @Validated @RequestBody CourseReq request,
            @PathVariable Long courseId) {
        return ResponseEntity.ok(this.courseService.update(courseId, request));
    }

    @DeleteMapping(path = "/{courseId}")
    @Override
    public ResponseEntity<Void> delete(
            @PathVariable Long courseId) {
        this.courseService.delete(courseId);

        return ResponseEntity.noContent().build();
    }

    /** Métodos no sobreescritos */

    // Actualizar únicamente la información del curso y no la del instructor del curso
    @PutMapping(path = "/{courseId}/updatedInfo")
    public ResponseEntity<CourseResp> updateInfoCourse(
            @Validated @RequestBody CourseUpdateReq request,
            @PathVariable Long courseId)
    {
     return ResponseEntity.ok(this.courseService.updateInfoCourse(courseId, request));
    }

    // Obtener las lessons de un course
    @GetMapping(path = "/{courseId}/lessons")
    public ResponseEntity<LessonByCourseResp> getLessons(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @PathVariable Long courseId) {
        return ResponseEntity.ok(this.courseService.getLessons(page - 1, size, courseId));
    }

}
