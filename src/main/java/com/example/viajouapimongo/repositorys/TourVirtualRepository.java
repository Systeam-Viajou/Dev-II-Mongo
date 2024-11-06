package com.example.viajouapimongo.repositorys;

import com.example.viajouapimongo.models.Imagem;
import com.example.viajouapimongo.models.TourVirtual;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TourVirtualRepository extends MongoRepository<TourVirtual, String> {
    Optional<TourVirtual> findByIdPontoTuristico(int idTurismo);
}
