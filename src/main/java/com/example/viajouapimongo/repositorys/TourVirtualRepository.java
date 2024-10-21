package com.example.viajouapimongo.repositorys;

import com.example.viajouapimongo.models.TourVirtual;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TourVirtualRepository extends MongoRepository<TourVirtual, String> {
}
