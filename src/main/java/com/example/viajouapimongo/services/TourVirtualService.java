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

    // Buscando todos os toures virtuais
    public List<TourVirtual> buscarTouresVirtiais() {
        return tourVirtualRepository.findAll();
    }

    // Buscando o tour virtual pelo id
    public TourVirtual buscarbuscarToureVirtialPorID(String id){
        return tourVirtualRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Tour virtual não encontrado"));
    }

    // Salvando e atualizando o tour virtual
    public TourVirtual salvarTourVirtual(TourVirtual tourVirtual) {
        return tourVirtualRepository.save(tourVirtual);    }
}
