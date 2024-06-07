package com.riwi.simulacro_prueba_spring_boot.api.controllers;

import com.riwi.simulacro_prueba_spring_boot.api.dto.errors.ErrorsResponse;
import com.riwi.simulacro_prueba_spring_boot.api.dto.request.UserReq;
import com.riwi.simulacro_prueba_spring_boot.api.dto.response.UserResp;
import com.riwi.simulacro_prueba_spring_boot.infraestructure.abstract_services.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
@Tag(name = "Users")
public class UserController implements ControllerBase<UserReq, UserResp, String>{

    @Autowired
    private final IUserService userService;

    @PostMapping
    @Operation(
            summary = "Create user",
            description = "Create user"
    )
    @Override
    public ResponseEntity<UserResp> create(
            @Validated @RequestBody UserReq request) {
        return ResponseEntity.ok(this.userService.create(request));
    }

    @GetMapping(path = "/{userId}")
    @ApiResponse(
            responseCode = "404",
            description = "NOT FOUND",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema (
                            implementation = ErrorsResponse.class
                    )
            )
    )
    @Override
    public ResponseEntity<UserResp> get(
            @PathVariable String userId) {
        return ResponseEntity.ok(this.userService.get(userId));
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<UserResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(this.userService.getAll(page-1, size));
    }

    @PutMapping(path = "/{userId}")
    @Override
    public ResponseEntity<UserResp> update(
            @Validated @RequestBody UserReq request,
            @PathVariable String userId) {
        return ResponseEntity.ok(this.userService.update(userId, request));
    }

    @DeleteMapping(path = "/{userId}")
    @Override
    public ResponseEntity<Void> delete(
            @PathVariable String userId) {
        this.userService.delete(userId);
        // noContent es un 204 y con .build() lo construimos para que sea una respuesta
        return ResponseEntity.noContent().build();
    }
}
