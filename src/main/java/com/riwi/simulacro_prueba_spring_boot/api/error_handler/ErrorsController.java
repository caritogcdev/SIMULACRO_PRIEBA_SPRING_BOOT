package com.riwi.simulacro_prueba_spring_boot.api.error_handler;

import com.riwi.simulacro_prueba_spring_boot.api.dto.errors.ErrorsResponse;
import com.riwi.simulacro_prueba_spring_boot.utils.exceptions.BadIdException;
import com.riwi.simulacro_prueba_spring_boot.utils.exceptions.BadRoleException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Para decirle a Java que acá se manejan los errores
 * se utiliza la anotación @RestControllerAdvice */
@RestControllerAdvice
public class ErrorsController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorsResponse handlerBadRequest(MethodArgumentNotValidException exception) {

        List<Map<String, String>> errors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            Map<String, String> errorResponse = new HashMap<>();

            errorResponse.put("Error", error.getDefaultMessage());
            errorResponse.put("Field", error.getField());

            errors.add(errorResponse);
        });

        return ErrorsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errors)
                .build();
    }

    @ExceptionHandler(BadIdException.class)
    public ErrorsResponse handlerIdError(BadIdException exception) {
        List<Map<String, String>> errors = new ArrayList<>();
        Map<String, String> errorResponse = new HashMap<>();

        errorResponse.put("Error", "ID not found");
        errorResponse.put("Entity", exception.getMessage());
        errors.add(errorResponse);

        return ErrorsResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.name())
                .errors(errors)
                .build();
    }

    @ExceptionHandler(BadRoleException.class)
    public ErrorsResponse handlerRoleError(BadRoleException exception) {
        Map<String, String> errorResponse = new HashMap<>();

        errorResponse.put("Error", "Role is "+exception.getMessage());

        return ErrorsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errorResponse)
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    public ErrorSimpleResponse handlerRequestError(BadRequestException exception) {
        Map<String, String> errorResponse = new HashMap<>();

        errorResponse.put("Error", exception.getMessage());

        return ErrorSimpleResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .error(errorResponse)
                .build();
    }

    @ExceptionHandler(NotAuthorizedException.class)
    public ErrorSimpleResponse handlerAuthorizedError(NotAuthorizedException exception) {
        Map<String, String> errorResponse = new HashMap<>();

        errorResponse.put("Error", exception.getMessage());

        return ErrorSimpleResponse.builder()
                .code(HttpStatus.FORBIDDEN.value())
                .status(HttpStatus.FORBIDDEN.name())
                .error(errorResponse)
                .build();
    }

}
