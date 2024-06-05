package com.riwi.simulacro_prueba_spring_boot.api.dto.response;

import com.riwi.simulacro_prueba_spring_boot.utils.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** En los DTO se mira que es lo que necesito responderle al usuario */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResp {
    private String id;
    private String full_name;
    private Role role;
}
