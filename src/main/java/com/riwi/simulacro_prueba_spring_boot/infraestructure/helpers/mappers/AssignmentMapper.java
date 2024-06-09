package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.AssignmentReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.AssignmentResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Assignment;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.LessonRepository;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.ServiceHelper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.IAssignmentMapper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.ILessonMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AssignmentMapper implements IAssignmentMapper {

    @Autowired
    private final ServiceHelper serviceHelper;

    @Autowired
    private final LessonRepository lessonRepository;

    @Autowired
    private final ILessonMapper lessonMapper;

    @Override
    public Assignment requestToEntity(AssignmentReq request) {
        return Assignment.builder()
                .assignment_title(request.getAssignment_title())
                .description(request.getDescription())
                .lessonId(this.serviceHelper.find(request.getLessonId(), lessonRepository, "lesson"))
                .build();
    }

    @Override
    public AssignmentResp entityToResponse(Assignment entity) {
        return AssignmentResp.builder()
                .id(entity.getId())
                .assignment_title(entity.getAssignment_title())
                .description(entity.getDescription())
                .due_date(entity.getDue_date())
                .lessonId(this.lessonMapper.entityToResponse(entity.getLessonId()))
                .build();
    }

    @Override
    public Assignment reqUpdateToEntity(AssignmentReq request) {
        return Assignment.builder()
                .assignment_title(request.getAssignment_title())
                .description(request.getDescription())
                .build();
    }
}
