package com.example.viajouapimongo.repositorys;

import com.example.viajouapimongo.models.Notificacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificacaoRepository extends MongoRepository<Notificacao, String> {
}
