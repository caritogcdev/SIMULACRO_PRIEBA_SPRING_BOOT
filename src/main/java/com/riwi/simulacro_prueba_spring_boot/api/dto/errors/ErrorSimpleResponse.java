package com.riwi.simulacro_prueba_spring_boot.api.dto.errors;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorSimpleResponse implements Serializable {
    private String status;
    private Integer code;
    private Map<String, String> error;
}
