package com.riwi.simulacro_prueba_spring_boot.infraestructure.services;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.SubmissionReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.SubmissionResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Submission;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.SubmissionRepository;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services.ISubmissionService;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.ServiceHelper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.ISubmissionMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubmissionService implements ISubmissionService {

    @Autowired
    private final SubmissionRepository submissionRepository;

    @Autowired
    private final ISubmissionMapper submissionMapper;

    @Autowired
    private final ServiceHelper serviceHelper;

    @Override
    public SubmissionResp create(SubmissionReq request) {
        Submission submission = this.submissionMapper.requestToEntity(request);

        return this.submissionMapper.entityToResponse(this.submissionRepository.save(submission));
    }

    @Override
    public SubmissionResp get(Long id) {
        Submission submission = this.serviceHelper.find(id, submissionRepository, "submission");
        return this.submissionMapper.entityToResponse(submission);
    }

    @Override
    public Page<SubmissionResp> getAll(int page, int size) {

        if (page < 0) page = 0;
        if (size <= 0) size = 5;

        return this.submissionRepository.findAll(PageRequest.of(page, size))
                .map(this.submissionMapper::entityToResponse);
    }

    @Override
    public SubmissionResp update(Long id, SubmissionReq request) {
        this.serviceHelper.find(id, submissionRepository, "submission");

        Submission submission = this.submissionMapper.requestToEntity(request);
        submission.setId(id);

        return this.submissionMapper.entityToResponse(this.submissionRepository.save(submission));
    }

    @Override
    public void delete(Long id) {
        Submission submission = this.serviceHelper.find(id, submissionRepository, "submission");

        this.submissionRepository.delete(submission);
    }

    /** Falta el mpetodo de:
     * 30. Obtener Todas las Entregas de un Usuario
     *  GET /users/{user_id}/submissions
     *  Descripción: Obtener todas las entregas de un usuario específico.
     * */
}
