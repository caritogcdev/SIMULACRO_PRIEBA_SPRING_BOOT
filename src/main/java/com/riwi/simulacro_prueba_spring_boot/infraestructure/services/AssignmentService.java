package com.riwi.simulacro_prueba_spring_boot.infraestructure.services;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.AssignmentReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.AssignmentResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Assignment;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.AssignmentRepository;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services.IAssignmentService;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.ServiceHelper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.IAssignmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssignmentService implements IAssignmentService {

    @Autowired
    private final AssignmentRepository assignmentRepository;

    @Autowired
    private final IAssignmentMapper assignmentMapper;

    @Autowired
    private final ServiceHelper serviceHelper;

    @Override
    public AssignmentResp create(AssignmentReq request) {
        Assignment assignment = this.assignmentMapper.requestToEntity(request);
        return this.assignmentMapper.entityToResponse(this.assignmentRepository.save(assignment));
    }

    @Override
    public AssignmentResp get(Long id) {
        Assignment assignment = this.serviceHelper.find(id, assignmentRepository, "assignment");
        return this.assignmentMapper.entityToResponse(assignment);
    }

    @Override
    public Page<AssignmentResp> getAll(int page, int size) {

        if (page < 0) page = 0;
        if (size <= 0) size = 5;

        return this.assignmentRepository.findAll(PageRequest.of(page, size))
                .map((assignment) -> this.assignmentMapper.entityToResponse(assignment));
    }

    @Override
    public AssignmentResp update(Long id, AssignmentReq request) {
        this.serviceHelper.find(id, assignmentRepository, "assignment");
        Assignment assignment = this.assignmentMapper.requestToEntity(request);
        assignment.setId(id);

        return this.assignmentMapper.entityToResponse(this.assignmentRepository.save(assignment));
    }

    @Override
    public void delete(Long id) {
        Assignment assignment = this.serviceHelper.find(id, assignmentRepository, "assignment");

        this.assignmentRepository.delete(assignment);
    }

    @Override
    public AssignmentResp updateInfoAssignment(Long id, AssignmentReq request) {

        Assignment assignmentData = this.serviceHelper.find(id, assignmentRepository, "assignment");

        Assignment assignment = this.assignmentMapper.reqUpdateToEntity(request);
        assignment.setId(id);

        assignment.setLessonId(assignmentData.getLessonId());

        return this.assignmentMapper.entityToResponse(this.assignmentRepository.save(assignment));
    }
}
