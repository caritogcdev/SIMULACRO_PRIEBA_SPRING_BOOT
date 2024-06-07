package com.riwi.simulacro_prueba_spring_boot.api.controllers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.AssignmentReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.AssignmentResp;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services.IAssignmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/assignments")
@AllArgsConstructor
@Tag(name = "Assignments")
public class AssignmentController implements ControllerBase<AssignmentReq, AssignmentResp, Long>{

    @Autowired
    private final IAssignmentService assignmentService;

    @PostMapping
    @Override
    public ResponseEntity<AssignmentResp> create(
            @Validated @RequestBody AssignmentReq request) {
        return ResponseEntity.ok(this.assignmentService.create(request));
    }

    @GetMapping(path = "/{assignmentId}")
    @Override
    public ResponseEntity<AssignmentResp> get(
            @PathVariable Long assignmentId) {
        return ResponseEntity.ok(this.assignmentService.get(assignmentId));
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<AssignmentResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(this.assignmentService.getAll(page - 1, size));
    }

    @PutMapping(path = "/{assignmentId}")
    @Override
    public ResponseEntity<AssignmentResp> update(
            @Validated @RequestBody  AssignmentReq request,
            @PathVariable Long assignmentId) {

        return ResponseEntity.ok(this.assignmentService.update(assignmentId, request));
    }

    @DeleteMapping(path = "/{assignmentId}")
    @Override
    public ResponseEntity<Void> delete(
            @PathVariable Long assignmentId) {

        this.assignmentService.delete(assignmentId);

        return ResponseEntity.noContent().build();
    }

    //Actualizar información únicamente de Assignment sin Lesson

    @PutMapping(path = "/{assignmentId}/updatedInfo")
    public ResponseEntity<AssignmentResp> updateInfoAssignment(
            @Validated @RequestBody AssignmentReq req,
            @PathVariable long assignmentId) {

        return ResponseEntity.ok(this.assignmentService.updateInfoAssignment(assignmentId, req));
    }
}
