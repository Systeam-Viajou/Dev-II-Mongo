package com.example.viajouapimongo.services;

import com.example.viajouapimongo.models.TourUsuario;
import com.example.viajouapimongo.repositorys.TourUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TourUsuarioService {

    @Autowired
    private TourUsuarioRepository tourUsuarioRepository;

    // Buscando todos os toures de usuario
    public List<TourUsuario> buscarTouresUsuarios() {
        return tourUsuarioRepository.findAll();
    }

    // Buscando o tour usuario pelo id
    public TourUsuario buscarTourUsuarioPorID(String id) {
        return tourUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour usuário não encontrado"));
    }

    // Salvando e atualizando o tour usuario
    public TourUsuario salvarTourUsuario(TourUsuario tourUsuario) {
        return tourUsuarioRepository.save(tourUsuario);
    }
}
