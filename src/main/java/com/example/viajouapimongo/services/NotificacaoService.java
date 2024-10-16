package com.example.viajouapimongo.services;

import com.example.viajouapimongo.models.Imagem;
import com.example.viajouapimongo.models.Notificacao;
import com.example.viajouapimongo.repositorys.ImagemRepository;
import com.example.viajouapimongo.repositorys.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {
    @Autowired
    private NotificacaoRepository notificacaoRepository;

    // Buscando todas as notificações
    public List<Notificacao> buscarNotificacoes() {
        return notificacaoRepository.findAll();
    }

    // Buscando a notificação pelo id
    public Notificacao buscarNotificacaoPorID(String id){
        return notificacaoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Notificação não encontrada"));
    }

    // Salvando e atualizando a notificação
    public Notificacao salvarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }
}