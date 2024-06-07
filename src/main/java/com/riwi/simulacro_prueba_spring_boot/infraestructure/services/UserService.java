package com.riwi.simulacro_prueba_spring_boot.infraestructure.services;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.UserReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.UserResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.User;
import com.riwi.simulacro_prueba_spring_boot.domain.repositories.UserRepository;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services.IUserService;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.ServiceHelper;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers.IUserMapper;
import com.riwi.simulacro_prueba_spring_boot.utils.enums.Role;
import com.riwi.simulacro_prueba_spring_boot.utils.exceptions.BadRoleException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        // Validamos que el rol esté lleno desde aquí (desde el servicio)
        if (request.getRole() == null) {
            throw new BadRoleException("Role is required");
        }
        try {
            Role.valueOf(request.getRole());
        }catch (Exception error){
            throw new BadRoleException("Role is invalid");
        }

        User user = this.userMapper.requestToEntity(request); //Entidad creada a partir de un request
        return this.userMapper.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public UserResp get(String id) {
        User user = this.serviceHelper.find(id, userRepository, "user");
        return this.userMapper.entityToResponse(user);
    }

    @Override
    public Page<UserResp> getAll(int page, int size) {
        if (page < 0) page = 0;
        if (size <= 0) size = 5;
        
        return this.userRepository.findAll(PageRequest.of(page, size))
                .map((entity) -> this.userMapper.entityToResponse(entity));
    }

    /** Este servicio actualiza los campos de un usuario a excepción del rol. */
    @Override
    public UserResp update(String id, UserReq request) {

        /** Validación para que si el rol que tiene en la DB es ADMIN, que sí se lo deje cambiar
         * de lo contrario, no. y comprobar que el rol esté dentro de los roles permitidos  */

        User userData = this.serviceHelper.find(id, userRepository, "user");

        if (userData.getRole() == Role.ADMIN && request.getRole() != null) {
            try {
                if (request.getRole() != null) {
                    Role.valueOf(request.getRole());
                }
            }catch (Exception e){
                throw new BadRoleException("Role is invalid");
            }
        } else {
            if (request.getRole() != null) {
                throw new BadRoleException("Role change is not allowed");
            }
        }

        if (request.getRole() == null) {
            // Transformando el emum rol a string con .name()
            request.setRole(userData.getRole().name());
        }

        // Si el rol es vacío, toca settear el rol que venga de la DB a la transformación de request
        // porque en la entidad lo colocamos como un campo obligatorio (requerido)
        User user = this.userMapper.requestToEntity(request);
        user.setId(id);

        // Esto no retorna una entidad sino un response
        return this.userMapper.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public void delete(String id) {
        User user = this.serviceHelper.find(id, userRepository, "user");
        this.userRepository.delete(user);
    }

}
