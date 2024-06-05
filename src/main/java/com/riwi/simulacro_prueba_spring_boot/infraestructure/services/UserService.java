package com.riwi.simulacro_prueba_spring_boot.infraestructure.services;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.UserReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.UserResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.User;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.UserRepository;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services.IUserService;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.ServiceHelper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.IUserMapper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor // Porque voy a inyectar dependencias en este servicio con el @Autowired
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final ServiceHelper serviceHelper;

    @Autowired
    private final IUserMapper userMapper;

    @Override
    public UserResp create(UserReq request) {
        if (request.getRole() == null) {

        }

        User user = this.userMapper.requestToEntity(request); //Entidad creada a partir de un request
        return this.userMapper.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public UserResp get(String s) {
        return null;
    }

    @Override
    public Page<UserResp> getAll(int page, int size) {
        return null;
    }

    @Override
    public UserResp update(String s, UserReq request) {
        return null;
    }

    @Override
    public void delete(String s) {

    }



}
