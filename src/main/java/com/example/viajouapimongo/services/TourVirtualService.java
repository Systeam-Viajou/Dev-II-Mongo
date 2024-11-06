package com.example.viajouapimongo.services;

import com.example.viajouapimongo.models.Imagem;
import com.example.viajouapimongo.models.TourVirtual;
import com.example.viajouapimongo.repositorys.TourVirtualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourVirtualService {
    @Autowired
    private TourVirtualRepository tourVirtualRepository;

    // Buscando todos os tours virtuais
    public List<TourVirtual> buscarTouresVirtiais() {
        return tourVirtualRepository.findAll();
    }

    // Buscando o tour virtual pelo id
    public TourVirtual buscarTourVirtualPorID(String id) {
        return tourVirtualRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour virtual não encontrado"));
    }

    // Buscando o tour virtual pelo ID do ponto turistico
    public Optional<TourVirtual> buscarTourVirtualPorIdTurismo(int idPonto) {
        return tourVirtualRepository.findByIdPontoTuristico(idPonto);
    }

    // Salvando e atualizando o tour virtual
    public TourVirtual salvarTourVirtual(TourVirtual tourVirtual) {
        if (tourVirtual == null) {
            throw new IllegalArgumentException("O objeto TourVirtual não pode ser nulo");
        }
        return tourVirtualRepository.save(tourVirtual);
    }
}
