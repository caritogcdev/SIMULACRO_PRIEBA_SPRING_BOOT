package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.SubmissionReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.SubmissionResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Submission;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.AssignmentRepository;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.UserRepository;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.ServiceHelper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.IAssignmentMapper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.ISubmissionMapper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.IUserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** Helper que vamos a inyectar dentro de nuestro
 * servicio, utilizamos la anotación @Component */

@Component
@AllArgsConstructor
public class SubmissionMapper implements ISubmissionMapper {

    @Autowired
    private final ServiceHelper helper;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final AssignmentRepository assignmentRepository;

    @Autowired
    private final IUserMapper userMapper;

    @Autowired
    private final IAssignmentMapper assignmentMapper;

    @Override
    public Submission requestToEntity(SubmissionReq request) {

        // Aquí retorno lo que está en el dto de request
        return Submission.builder()
                .content(request.getContent())
                .userId(this.helper.find(request.getUserId(), userRepository, "user"))
                .assignmentId(this.helper.find(request.getAssignmentId(), assignmentRepository, "assignment"))
                .build();
    }

    @Override
    public SubmissionResp entityToResponse(Submission entity) {
        return SubmissionResp.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .submission_date(entity.getSubmission_date())
                .grade(entity.getGrade())
                .userId(this.userMapper.entityToResponse(entity.getUserId()))
                .assignmentId(this.assignmentMapper.entityToResponse(entity.getAssignmentId()))
                .build();
    }
}
