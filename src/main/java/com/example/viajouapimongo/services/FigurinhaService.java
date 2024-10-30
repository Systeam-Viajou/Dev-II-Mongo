package com.example.viajouapimongo.services;

import com.example.viajouapimongo.models.Figurinha;
import com.example.viajouapimongo.repositorys.FigurinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FigurinhaService {

    @Autowired
    private FigurinhaRepository figurinhaRepository;

    // Buscando todas as figurinhas
    public List<Figurinha> buscarFigurinha() {
        return figurinhaRepository.findAll();
    }

    // Buscando a figurinha pelo ID
    public Figurinha buscarFigurinhaPorID(String id) {
        return figurinhaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Figurinha não encontrada com o ID: " + id));
    }

    // Salvando e atualizando a imagem
    public Figurinha salvarFigurinha(Figurinha figurinha) {
        if (figurinha == null) {
            throw new IllegalArgumentException("O objeto Figurinha não pode ser nulo");
        }
        return figurinhaRepository.save(figurinha);
    }
}
