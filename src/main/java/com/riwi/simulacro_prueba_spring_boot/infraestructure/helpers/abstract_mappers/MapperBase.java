package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers.abstract_mappers;

public interface MapperBase <RequestDTO, Entity, ResponseDTO>{
    Entity requestToEntity(RequestDTO request);
    ResponseDTO entityToResponse(Entity entity);
}
