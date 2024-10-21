package com.example.viajouapimongo.controllers;

import com.example.viajouapimongo.models.TourVirtual;
import com.example.viajouapimongo.services.TourVirtualService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/viajouapi/mongo/touresvirtuais")
public class TourVirtualController {

    @Autowired
    private TourVirtualService tourVirtualService;

    @Operation(summary = "Buscar todos os tours virtuais")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de tours virtuais retornada com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TourVirtual.class)) }),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/buscar")
    public List<TourVirtual> buscarTourVirtual() {
        return tourVirtualService.buscarTouresVirtiais();
    }

    @Operation(summary = "Inserir um novo tour virtual")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tour virtual inserido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na validação do tour virtual"),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    @PostMapping("/inserir")
    public ResponseEntity<?> inserirTourVirtual(
            @Valid @RequestBody TourVirtual tourVirtual,
            BindingResult resultado) {

        if (resultado.hasErrors()) {
            Map<String, String> erros = new HashMap<>();

            for (FieldError erro : resultado.getFieldErrors()) {
                erros.put(erro.getField(), erro.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
        } else {
            tourVirtualService.salvarTourVirtual(tourVirtual);
            return ResponseEntity.ok("Tour virtual inserido com sucesso");
        }
    }
}
