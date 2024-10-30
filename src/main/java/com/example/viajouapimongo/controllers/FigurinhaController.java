package com.example.viajouapimongo.controllers;

import com.example.viajouapimongo.models.Figurinha;
import com.example.viajouapimongo.services.FigurinhaService;
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
@RequestMapping("/viajouapi/mongo/figurinhas")
public class FigurinhaController {

    @Autowired
    private FigurinhaService figurinhaService;

    @Operation(summary = "Buscar todas as figurinhas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de imagens retornada com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Figurinha.class)) }),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/buscar")
    public ResponseEntity<List<Figurinha>> buscarFigurinhas() {
        List<Figurinha> imagens = figurinhaService.buscarFigurinha();
        return ResponseEntity.ok(imagens);
    }

    @Operation(summary = "Inserir nova figurinha")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Figurinha inserida com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na validação da imagem"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/inserir")
    public ResponseEntity<?> inserirFigurinha(
            @Valid @RequestBody Figurinha figurinha, BindingResult resultado) {

        if (resultado.hasErrors()) {
            Map<String, String> erros = new HashMap<>();
            for (FieldError erro : resultado.getFieldErrors()) {
                erros.put(erro.getField(), erro.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
        } else {
            try {
                figurinhaService.salvarFigurinha(figurinha);
                return ResponseEntity.ok("Figurinha inserida com sucesso");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Erro ao salvar figurinha: " + e.getMessage());
            }
        }
    }
}
