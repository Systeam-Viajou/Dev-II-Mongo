package com.example.viajouapimongo.repositorys;

import com.example.viajouapimongo.models.Figurinha;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FigurinhaRepository extends MongoRepository<Figurinha, String> {
}
