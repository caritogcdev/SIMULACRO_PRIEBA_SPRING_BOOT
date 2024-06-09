package com.riwi.simulacro_prueba_spring_boot.api.controllers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.SubmissionReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.SubmissionResp;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services.ISubmissionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/submissions")
@AllArgsConstructor
@Tag(name = "Submissions")
public class SubmissionController implements BaseController<SubmissionReq, SubmissionResp, Long>{

    @Autowired
    private final ISubmissionService submissionService;

    @PostMapping
    @Override
    public ResponseEntity<SubmissionResp> create(
            @Validated @RequestBody SubmissionReq request) {
        return ResponseEntity.ok(this.submissionService.create(request));
    }

    @GetMapping(path = "/{submissionId}")
    @Override
    public ResponseEntity<SubmissionResp> get(
            @PathVariable Long submissionId) {
        return ResponseEntity.ok(this.submissionService.get(submissionId));
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<SubmissionResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(this.submissionService.getAll(page - 1, size));
    }

    @PutMapping(path = "/{submissionId}")
    @Override
    public ResponseEntity<SubmissionResp> update(
            @Validated @RequestBody SubmissionReq request,
            @PathVariable Long submissionId) {
        return ResponseEntity.ok(this.submissionService.update(submissionId, request));
    }

    @DeleteMapping(path = "/{submissionId}")
    @Override
    public ResponseEntity<Void> delete(
            @PathVariable Long submissionId) {

        this.submissionService.delete(submissionId);
        return ResponseEntity.noContent().build();
    }
}
