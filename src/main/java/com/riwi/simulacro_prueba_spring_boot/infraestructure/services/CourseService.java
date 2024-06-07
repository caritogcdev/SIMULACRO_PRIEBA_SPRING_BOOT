package com.riwi.simulacro_prueba_spring_boot.infraestructure.services;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.CourseReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.request.CourseUpdateReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.CourseResp;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.LessonByCourseResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Course;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.CourseRepository;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.UserRepository;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services.ICourseService;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.ServiceHelper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.ICourseMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService {

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final ServiceHelper serviceHelper;

    @Autowired
    private final ICourseMapper courseMapper;

    @Override
    public CourseResp create(CourseReq request) {
        Course course = this.courseMapper.requestToEntity(request);
        return this.courseMapper.entityToResponse(this.courseRepository.save(course));
    }

    @Override
    public CourseResp get(Long id) {
        Course course = this.serviceHelper.find(id, courseRepository, "course");
        return this.courseMapper.entityToResponse(course);
    }

    @Override
    public Page<CourseResp> getAll(int page, int size) {
        if (page < 0) page = 0;
        if (size < 1) size = 5;

        return this.courseRepository.findAll(PageRequest.of(page, size))
                .map((course) -> this.courseMapper.entityToResponse(course));

    }

    @Override
    public CourseResp update(Long id, CourseReq request) {
        Course courseData = this.serviceHelper.find(id, courseRepository, "course");
        Course course = this.courseMapper.requestToEntity(request);

        // Validación del instructor si es nulo o no
        if (request.getUserInstructor() == null){
            course.setUserInstructor(courseData.getUserInstructor());
        } else {
            this.serviceHelper.find(request.getUserInstructor(), userRepository, "User Instructor ID");
        }

        course.setId(id);

        return this.courseMapper.entityToResponse(this.courseRepository.save(course));
    }

    @Override
    public void delete(Long id) {
        Course course = this.serviceHelper.find(id, courseRepository, "course");
        this.courseRepository.delete(course);
    }

    @Override
    public CourseResp updateInfoCourse(Long id, CourseUpdateReq request) {

        Course courseData = this.serviceHelper.find(id, courseRepository, "course");
        Course course = this.courseMapper.reqUpdateToEntity(request);
        course.setId(id);
        course.setUserInstructor(courseData.getUserInstructor());

        return this.courseMapper.entityToResponse(this.courseRepository.save(course));
    }

    @Override
    public LessonByCourseResp getLessons(int page, int size, Long id) {
        this.serviceHelper.find(id, courseRepository, "course");

        throw new UnsupportedOperationException("Unimplemented method 'getLessons'");
    }
}
