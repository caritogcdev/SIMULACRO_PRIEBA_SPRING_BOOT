package com.riwi.simulacro_prueba_spring_boot.api.dto.request;

import com.riwi.simulacro_prueba_spring_boot.utils.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Datos de entrada que necesito pedirle al usuario */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReq {
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "Email is required")
    @Email(message = "Email is invalid") //Verifica que si exista un @ seguido de otra cosa (un email válido)
    private String email;

    private String fullName;

    private String role;
}
