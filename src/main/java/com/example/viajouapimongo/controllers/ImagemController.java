package com.example.viajouapimongo.controllers;

import com.example.viajouapimongo.models.Imagem;
import com.example.viajouapimongo.repositorys.ImagemRepository;
import com.example.viajouapimongo.services.ImagemService;
import io.swagger.v3.oas.annotations.Parameter;
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
import java.util.UUID;

@RestController
@RequestMapping("/viajouapi/mongo/imagens")
public class ImagemController {
    @Autowired
    private ImagemService imagemService;

    @GetMapping("/buscar")
    public List<Imagem> buscarImagens() {
        return imagemService.buscarImagens();
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<Imagem> buscarImagemPorIdCategoria(@PathVariable Long idAtracao) {
        return imagemService.getImagemByIdAtracao(idAtracao)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


//    @PostMapping("/inserir")
//    public ResponseEntity<?> inserirImagem(@Valid @RequestBody Imagem imagem, BindingResult resultado) {
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
//            imagemService.salvarImagem(imagem);
//            return ResponseEntity.ok("Imagem inserida com sucesso");
//        }
//    }

}