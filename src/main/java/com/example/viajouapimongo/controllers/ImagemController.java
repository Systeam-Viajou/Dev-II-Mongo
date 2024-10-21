package com.example.viajouapimongo.controllers;

import com.example.viajouapimongo.models.Imagem;
import com.example.viajouapimongo.models.Notificacao;
import com.example.viajouapimongo.services.ImagemService;
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
@RequestMapping("/viajouapi/mongo/imagens")
public class ImagemController {

    @Autowired
    private ImagemService imagemService;

    @Operation(summary = "Buscar todas as imagens")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de imagens retornada com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Imagem.class)) }),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/buscar")
    public List<Imagem> buscarImagens() {
        return imagemService.buscarImagens();
    }

    @Operation(summary = "Buscar imagem por ID da categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Imagem encontrada com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Imagem.class)) }),
            @ApiResponse(responseCode = "404", description = "Imagem não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/{idCategoria}")
    public ResponseEntity<Imagem> buscarImagemPorIdCategoria(
            @Parameter(description = "ID da categoria de atração") @PathVariable Long idAtracao) {
        return imagemService.getImagemByIdAtracao(idAtracao)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Inserir nova imagem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Imagem inserida com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na validação da magem"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/inserir")
    public ResponseEntity<?> inserirImagem(
            @Valid @RequestBody Imagem imagem, BindingResult resultado) {

        if (resultado.hasErrors()) {
            Map<String, String> erros = new HashMap<>();

            for (FieldError erro : resultado.getFieldErrors()) {
                erros.put(erro.getField(), erro.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
        } else {
            imagemService.salvarImagem(imagem);
            return ResponseEntity.ok("Imagem inserida com sucesso");
        }
    }
}
