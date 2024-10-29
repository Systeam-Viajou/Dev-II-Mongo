package com.example.viajouapimongo.services;

import com.example.viajouapimongo.models.Imagem;
import com.example.viajouapimongo.repositorys.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository imagemRepository;

    // Buscando todas as imagens
    public List<Imagem> buscarImagens() {
        return imagemRepository.findAll();
    }

    // Buscando a imagem pelo ID
    public Imagem buscarImagemPorID(String id) {
        return imagemRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Imagem não encontrada com o ID: " + id));
    }

    // Buscando a imagem pelo ID da atração
    public Optional<Imagem> getImagemByIdAtracao(Long idAtracao) {
        return imagemRepository.findByIdAtracao(idAtracao);
    }

    // Salvando e atualizando a imagem
    public Imagem salvarImagem(Imagem imagem) {
        if (imagem == null) {
            throw new IllegalArgumentException("O objeto Imagem não pode ser nulo");
        }
        return imagemRepository.save(imagem);
    }
}
