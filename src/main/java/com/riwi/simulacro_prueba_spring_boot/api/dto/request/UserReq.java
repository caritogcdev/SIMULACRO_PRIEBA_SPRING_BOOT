package com.riwi.simulacro_prueba_spring_boot.api.dto.request;

import com.riwi.simulacro_prueba_spring_boot.utils.enums.Role;

/** Datos de entrada que necesito pedirle al usuario */
public class UserReq {
    //private String user_id;
    private String username;
    private String password;
    private String email;
    private String full_name;
    private Role role;
}
