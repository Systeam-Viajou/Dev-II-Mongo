package com.example.viajouapimongo.repositorys;

import com.example.viajouapimongo.models.Imagem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ImagemRepository extends MongoRepository<Imagem, String> {
    Optional<Imagem> findByIdAtracao(Long idAtracao);
}
