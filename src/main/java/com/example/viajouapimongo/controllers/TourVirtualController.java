package com.example.viajouapimongo.controllers;

import com.example.viajouapimongo.models.Notificacao;
import com.example.viajouapimongo.models.TourVirtual;
import com.example.viajouapimongo.services.NotificacaoService;
import com.example.viajouapimongo.services.TourVirtualService;
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

    @GetMapping("/buscar")
    public List<TourVirtual> buscarTourVirtual() {
        return tourVirtualService.buscarTouresVirtiais();
    }

    @PostMapping("/inserir")
    public ResponseEntity<?> inserirTourVirtual(@Valid @RequestBody TourVirtual tourVirtual, BindingResult resultado) {

        if(resultado.hasErrors()){
            Map<String, String> erros = new HashMap<>();

            for (FieldError erro : resultado.getFieldErrors()) {
                erros.put(erro.getField(), erro.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
        }
        else{
            tourVirtualService.salvarTourVirtual(tourVirtual);
            return ResponseEntity.ok("Tour virtual inserido com sucesso");
        }
    }
}
