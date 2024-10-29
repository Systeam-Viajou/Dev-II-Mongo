package com.example.viajouapimongo.repositorys;

import com.example.viajouapimongo.models.TourUsuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TourUsuarioRepository extends MongoRepository<TourUsuario, String> {
}
