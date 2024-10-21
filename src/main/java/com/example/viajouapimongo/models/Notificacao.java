package com.example.viajouapimongo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Schema(description = "Modelo que representa uma Notificação")
@Document(collection = "notificacoes")
public class Notificacao {

    @Id
    @Field("_id")
    @Schema(description = "ID único da notificação", example = "6716441b3ad11a78e3dee529")
    private String id;

    @Schema(description = "Título da notificação", example = "Novo evento chegando!")
    private String titulo;

    @Schema(description = "Descrição da notificação", example = "Participe dos eventos exclusivos disponíveis agora no app.")
    private String descricao;

    @Schema(description = "Categoria da notificação", example = "evento")
    private String categoria;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
