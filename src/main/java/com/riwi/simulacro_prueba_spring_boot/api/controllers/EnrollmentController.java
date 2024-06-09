package com.riwi.simulacro_prueba_spring_boot.api.controllers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.EnrollmentReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.EnrollmentResp;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services.IEnrollmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/enrollments")
@AllArgsConstructor
@Tag(name = "Enrollments")
public class EnrollmentController implements BaseController<EnrollmentReq, EnrollmentResp, Long>{

    @Autowired
    private final IEnrollmentService enrollmentService;

    @PostMapping
    @Override
    public ResponseEntity<EnrollmentResp> create(
            @Validated @RequestBody EnrollmentReq request) {
        return ResponseEntity.ok(this.enrollmentService.create(request));
    }

    @GetMapping(path = "/{enrollmentId}")
    @Override
    public ResponseEntity<EnrollmentResp> get(
            @PathVariable Long enrollmentId) {
        return ResponseEntity.ok(this.enrollmentService.get(enrollmentId));
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<EnrollmentResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(this.enrollmentService.getAll(page - 1, size));
    }

    @Override
    public ResponseEntity<EnrollmentResp> update(EnrollmentReq request, Long enrollmentId) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
        // return null;
    }

    @DeleteMapping(path = "/{enrollmentId}")
    @Override
    public ResponseEntity<Void> delete(
            @PathVariable Long enrollmentId) {

        this.enrollmentService.delete(enrollmentId);

        return ResponseEntity.noContent().build();
    }
}
