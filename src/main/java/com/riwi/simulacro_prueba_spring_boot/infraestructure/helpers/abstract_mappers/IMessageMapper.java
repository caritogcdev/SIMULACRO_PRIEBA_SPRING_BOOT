package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.request.MessageReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.MessageResp;
import com.riwi.simulacro_prueba_spring_boot.domain.entities.Message;

/** Puede que no se necesiten todos los mappers pero desntro de
 * cada entidad se usará al menos una vez */
public interface IMessageMapper extends MapperBase<MessageReq, Message, MessageResp>{

}
