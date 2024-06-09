package com.riwi.simulacro_prueba_spring_boot.infraestructure.services;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.EnrollmentReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.EnrollmentResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Enrollment;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.EnrollmentRepository;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services.IEnrollmentService;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.ServiceHelper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.IEnrollmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnrollmentService implements IEnrollmentService {

    @Autowired
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    private final IEnrollmentMapper enrollmentMapper;

    @Autowired
    private final ServiceHelper serviceHelper;

    @Override
    public EnrollmentResp create(EnrollmentReq request) {
        Enrollment enrollment = this.enrollmentMapper.requestToEntity(request);
        return this.enrollmentMapper.entityToResponse(this.enrollmentRepository.save(enrollment));
    }

    @Override
    public EnrollmentResp get(Long id) {
        Enrollment enrollment = this.serviceHelper.find(id, enrollmentRepository, "enrollment");
        return this.enrollmentMapper.entityToResponse(enrollment);
    }

    @Override
    public Page<EnrollmentResp> getAll(int page, int size) {

        if (page < 0) page = 0;
        if (size <= 0) size = 5;

        return this.enrollmentRepository.findAll(PageRequest.of(page, size))
                .map(this.enrollmentMapper::entityToResponse);
    }

    @Override
    public EnrollmentResp update(Long id, EnrollmentReq request) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");

        //return null;
    }

    @Override
    public void delete(Long id) {
        Enrollment enrollment = this.serviceHelper.find(id, enrollmentRepository, "enrollment");
        this.enrollmentRepository.delete(enrollment);
    }

    /** Faltan los métodos de:
     * 23. Obtener Todos los Cursos Inscritos por un Usuario
     *  GET /users/{user_id}/courses
     *  Descripción: Obtener todos los cursos en los que está inscrito un usuario
     * específico.
     *
     * 24. Obtener Todos los Usuarios Inscritos en un Curso
     *  GET /courses/{course_id}/users
     *  Descripción: Obtener todos los usuarios inscritos en un curso específico.
     * */

}
