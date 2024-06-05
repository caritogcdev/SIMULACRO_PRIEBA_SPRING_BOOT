package com.riwi.simulacro_prueba_spring_boot.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageReq {
    @NotBlank(message = "User sender is required")
    private String userSender;
    private String userReceiver;
    private Long courseId;
    @NotBlank(message = "Message content is required")
    private String message_content;
}
