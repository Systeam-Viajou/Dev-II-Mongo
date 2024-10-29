package com.example.viajouapimongo.services;

import com.example.viajouapimongo.models.TourVirtual;
import com.example.viajouapimongo.repositorys.TourVirtualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourVirtualService {
    @Autowired
    private TourVirtualRepository tourVirtualRepository;

    // Buscando todos os tours virtuais
    public List<TourVirtual> buscarTouresVirtiais() {
        return tourVirtualRepository.findAll();
    }

    // Buscando o tour virtual pelo id
    public TourVirtual buscarToureVirtialPorID(String id) {
        return tourVirtualRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour virtual não encontrado com o ID: " + id));
    }

    // Salvando e atualizando o tour virtual
    public TourVirtual salvarTourVirtual(TourVirtual tourVirtual) {
        if (tourVirtual == null) {
            throw new IllegalArgumentException("O objeto TourVirtual não pode ser nulo");
        }
        return tourVirtualRepository.save(tourVirtual);
    }
}
