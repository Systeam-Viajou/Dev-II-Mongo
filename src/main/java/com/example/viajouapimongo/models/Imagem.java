package com.example.viajouapimongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "imagem")
public class Imagem {

    @Id
    @Field("_id")
    private String id;

    private String url;

    @Field("id_atracao")
    private Long idAtracao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getIdAtracao() {
        return idAtracao;
    }

    public void setIdAtracao(Long idAtracao) {
        this.idAtracao = idAtracao;
    }
}
