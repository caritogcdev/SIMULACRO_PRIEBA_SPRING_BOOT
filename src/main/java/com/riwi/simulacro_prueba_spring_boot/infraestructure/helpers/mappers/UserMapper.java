package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.UserReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.UserResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.User;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.IUserMapper;
import com.riwi.simulacro_prueba_spring_boot.utils.enums.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper implements IUserMapper {

    @Override
    public User requestToEntity(UserReq request) {
        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .fullName(request.getFullName())
                .role(Role.valueOf(String.valueOf(request.getRole())))
                .build();
    }

    @Override
    public UserResp entityToResponse(User entity) {
        return UserResp.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .role(entity.getRole())
                .build();
    }
}
