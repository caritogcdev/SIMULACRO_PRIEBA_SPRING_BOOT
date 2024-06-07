package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.UserReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.UserResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.User;

/** Puede que no se necesiten todos los mappers pero dentro de
 * cada entidad se usará al menos una vez */
public interface IUserMapper extends MapperBase<UserReq, User, UserResp>{

}
