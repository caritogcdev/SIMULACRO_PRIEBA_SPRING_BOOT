package com.riwi.simulacro_prueba_spring_boot.infraestructure.helpers;

import com.riwi.simulacro_prueba_spring_boot.utils.exceptions.BadIdException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Helper para transformar una */
@Component
public class ServiceHelper {

    /** Transforma de lista de entidad a lista de entidad de respuesta */
    public <Entity, ResponseDTO> List<ResponseDTO> transformList(
            List<Entity> entities,
            Function<Entity, ResponseDTO> entityToResponse) {
        return entities.stream()
                .map(entityToResponse)
                .collect(Collectors.toList());
    }

    /** find por id genérico
     * Recibo el repositorio para poder castear o
     * usar el repositorio dependiendo del ID, es decir,
     * que le paso el repositorio que haga referencia a ese ID
     *
     * Para manejar errores, también recibe el nombre de
     * la entidad
     * */
    public <Entity, ID> Entity find(ID id, JpaRepository<Entity, ID> repository, String name){
        return repository.findById(id)
                .orElseThrow(() -> new BadIdException(name));
    }
}
