package com.riwi.simulacro_prueba_spring_boot.api.dto.request;

import java.time.LocalDate;

public class SubmissionReq {
    // private Long submission_id;
    private String content;
    private LocalDate submission_date;
    private Long user_id;
    private Long assignment_id;
}
