package com.riwi.simulacro_prueba_spring_boot.api.dto.request;

import java.time.LocalDate;

public class MessageReq {
    // private Long message_id;
    private Long receiver_id;
    private Long sender_id;
    private Long course_id;
    private String message_content;
    private LocalDate sent_date;
}
