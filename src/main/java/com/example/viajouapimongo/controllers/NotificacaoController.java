package com.example.viajouapimongo.controllers;

import com.example.viajouapimongo.models.Imagem;
import com.example.viajouapimongo.models.Notificacao;
import com.example.viajouapimongo.services.ImagemService;
import com.example.viajouapimongo.services.NotificacaoService;
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

    @GetMapping("/buscar")
    public List<Notificacao> buscarNotificacao() {
        return notificacaoService.buscarNotificacoes();
    }

//    @PostMapping("/inserir")
//    public ResponseEntity<?> inserirNotificacao(@Valid @RequestBody Notificacao notificacao, BindingResult resultado) {
//
//        if(resultado.hasErrors()){
//            Map<String, String> erros = new HashMap<>();
//
//            for (FieldError erro : resultado.getFieldErrors()) {
//                erros.put(erro.getField(), erro.getDefaultMessage());
//            }
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
//        }
//        else{
//            notificacaoService.salvarNotificacao(notificacao);
//            return ResponseEntity.ok("Notificação inserida com sucesso");
//        }
//    }
}
