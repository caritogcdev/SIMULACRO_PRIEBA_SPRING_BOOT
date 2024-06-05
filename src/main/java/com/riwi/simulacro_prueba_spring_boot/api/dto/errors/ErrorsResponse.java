package com.riwi.simulacro_prueba_spring_boot.api.dto.errors;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
/** Serializable para los estados de error HTTP */
public class ErrorsResponse implements Serializable {
    private String status;
    private Integer code;
    // Lista de errores
    private List<Map<String, String>> errors;
}
