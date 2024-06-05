package com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services;

import org.springframework.data.domain.Page;

public interface ServiceBase <RequestDTO, ResponseDTO, ID>{
    public ResponseDTO create(RequestDTO request);

    public ResponseDTO get(ID id);

    public Page<ResponseDTO> getAll(int page, int size);

    public ResponseDTO update(ID id, RequestDTO request);

    public void delete(ID id);
}
