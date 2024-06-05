package com.riwi.simulacro_prueba_spring_boot.domain.repositories;

import com.riwi.simulacro_prueba_spring_boot.domain.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

}
