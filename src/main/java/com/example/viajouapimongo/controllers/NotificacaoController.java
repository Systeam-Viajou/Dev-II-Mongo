package com.example.viajouapimongo.controllers;

import com.example.viajouapimongo.models.Notificacao;
import com.example.viajouapimongo.services.NotificacaoService;
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
@RequestMapping("/viajouapi/mongo/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @Operation(summary = "Buscar todas as notificações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de notificações retornada com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Notificacao.class)) }),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    @GetMapping("/buscar")
    public List<Notificacao> buscarNotificacao() {
        return notificacaoService.buscarNotificacoes();
    }

    @Operation(summary = "Inserir nova notificação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificação inserida com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na validação da notificação"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/inserir")
    public ResponseEntity<?> inserirNotificacao(
            @Valid @RequestBody Notificacao notificacao,
            BindingResult resultado) {

        if (resultado.hasErrors()) {
            Map<String, String> erros = new HashMap<>();

            for (FieldError erro : resultado.getFieldErrors()) {
                erros.put(erro.getField(), erro.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
        } else {
            notificacaoService.salvarNotificacao(notificacao);
            return ResponseEntity.ok("Notificação inserida com sucesso");
        }
    }

    @Operation(summary = "Gerar notificação aleatória")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificação aleatória gerada com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Notificacao.class)) }),
            @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    @GetMapping("/aleatoria")
    public ResponseEntity<Notificacao> gerarNotificacaoAleatoria() {
        try {
            Notificacao notificacaoAleatoria = notificacaoService.gerarNotificacaoAleatoria();
            return ResponseEntity.ok(notificacaoAleatoria);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
