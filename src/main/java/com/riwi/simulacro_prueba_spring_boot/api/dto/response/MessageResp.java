package com.riwi.simulacro_prueba_spring_boot.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResp {
    private Long id;
    private String message_content;
    private LocalDateTime sent_date;
    private UserResp userSender;
    private UserResp userReceiver;
    private CourseResp courseId;

}
